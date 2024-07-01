package org.geeksforgeeks;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findByExternalTxnId(String txnId); // null
}
