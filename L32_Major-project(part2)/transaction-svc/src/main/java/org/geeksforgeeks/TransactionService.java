package org.geeksforgeeks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    private JSONParser parser = new JSONParser();

    public String initiateTxn(Integer sender, Integer receiver, Long amount, String reason) throws JsonProcessingException {

        Transaction transaction = Transaction.builder()
                .externalTxnId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .sender(sender)
                .receiver(receiver)
                .amount(amount)
                .reason(reason)
                .build();

        this.transactionRepository.save(transaction);

        JSONObject obj = this.objectMapper.convertValue(transaction, JSONObject.class);

        this.kafkaTemplate.send("transaction-created", this.objectMapper.writeValueAsString(obj));

        return transaction.getExternalTxnId();
    }

    @KafkaListener(topics = "wallet-updates", groupId = "jbdl68")
    public void completeTxn(String msg) throws ParseException {

        this.logger.info("completeTxn: received msg = {}", msg);

        JSONObject object = (JSONObject) this.parser.parse(msg);

        String externalTxnId = (String) object.get("externalTxnId"); // null
        String walletUpdateStatus = (String) object.get("status");

        Transaction transaction = this.transactionRepository.findByExternalTxnId(externalTxnId);
        this.logger.info("completeTxn: transaction object is - {}", transaction);
        if(!transaction.getTransactionStatus().equals(TransactionStatus.PENDING)){
            this.logger.warn("transaction already reached terminal state, id - {}", externalTxnId);
            return;
        }

        TransactionStatus transactionStatus = walletUpdateStatus.equals("SUCCESS") ?
                TransactionStatus.SUCCESS :
                TransactionStatus.FAILED;

        transaction.setTransactionStatus(transactionStatus);

        this.transactionRepository.save(transaction);

        //TODO: Publish a txn complete event which can be listened by a notification svc to send an email
        // to sender and receiver

    }
}
