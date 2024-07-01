package org.geeksforgeeks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WalletService {

    private Logger logger = LoggerFactory.getLogger(WalletService.class);

    private JSONParser parser = new JSONParser();

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("${wallet.promotional.balance}")
    private Long balance;

    // listener / watcher
    @KafkaListener(topics = {"user-created"}, groupId = "test123")
    public void createWallet(String msg){
        try {
            JSONObject obj = (JSONObject) this.parser.parse(msg);
            Long user = (Long) (obj.get("id"));
            Integer userId = user.intValue();

            Wallet wallet = this.walletRepository.findByUserId(userId.intValue());
            if(wallet != null){
                this.logger.info("wallet for user - {} already created hence not creating again..", userId);
                return;
            }

            wallet = Wallet.builder()
                    .id(UUID.randomUUID().toString())
                    .userId(userId)
                    .balance(balance)
                    .status(WalletStatus.ACTIVE)
                    .build();

            this.walletRepository.save(wallet);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = {"transaction-created"}, groupId = "test123")
    public void updateWallets(String msg){
        try {
            JSONObject obj = (JSONObject) this.parser.parse(msg);
            Long sender = (Long) (obj.get("sender"));
            Long receiver = (Long) (obj.get("receiver"));
            Long amount = (Long) (obj.get("amount"));

            String externalTxnId = (String)obj.get("externalTxnId");

            Integer senderId = sender.intValue();
            Integer receiverId = receiver.intValue();

            Wallet receiverWallet = this.walletRepository.findByUserId(receiverId);
            Wallet senderWallet = this.walletRepository.findByUserId(senderId);

            if(receiverWallet == null || senderWallet == null || amount <= 0 || senderWallet.getBalance() < amount){
                this.logger.error("wallet update cannot be done due to either wallet not present or balance not sufficient");
                //TODO: Publish a message on the wallet_update topic with the status as failed
                // Make the transaction as success

                // Make the transaction as failed

                JSONObject event = new JSONObject();
                event.put("status", "FAILED");
                event.put("sender", senderId);
                event.put("receiver", receiverId);
                event.put("externalTxnId", externalTxnId);

                this.kafkaTemplate.send("wallet-updates", objectMapper.writeValueAsString(event));
                return;

            }


            // Approach 1
//            this.walletRepository.incrementWallet(receiverWallet.getId(), amount);
//            this.walletRepository.decrementWallet(senderWallet.getId(), amount);

            /**
             *  sender - 500
             *  receiver - 200
             *
             *  amount = 100
             *  receiver, 200 + 100 = 300
             *  sender, 500 + (-100) = 400
             */

            // Approach 2
//            this.walletRepository.updateWallet(receiverWallet.getId(), amount);
//            this.walletRepository.updateWallet(senderWallet.getId(), -amount);


            // Approach 3
            receiverWallet.setBalance(receiverWallet.getBalance() + amount);
            senderWallet.setBalance(senderWallet.getBalance() - amount);

            this.walletRepository.saveAll(List.of(receiverWallet, senderWallet));
            //TODO: Publish a message about the wallet updates

            JSONObject event = new JSONObject();
            event.put("status", "SUCCESS");
            event.put("sender", senderId);
            event.put("receiver", receiverId);
            event.put("externalTxnId", externalTxnId);

            this.kafkaTemplate.send("wallet-updates", objectMapper.writeValueAsString(event));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
