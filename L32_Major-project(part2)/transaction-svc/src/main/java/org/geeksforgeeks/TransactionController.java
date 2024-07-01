package org.geeksforgeeks;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/initiate")
    public String initiateTxn(@RequestParam("sender") Integer sender,
                              @RequestParam("receiver") Integer receiver,
                              @RequestParam("amount") Long amount,
                              @RequestParam("reason") String reason) throws JsonProcessingException {
        return this.transactionService.initiateTxn(sender, receiver, amount, reason);
    }
}
