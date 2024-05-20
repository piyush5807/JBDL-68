package com.example.minorproject1.repositories;

import com.example.minorproject1.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    /**
     * S1  -->   B1   (Issuance)    T1
     * S1  -->   B1   (Return)      T2
     * S1  -->   B1   (Issuance)    T3
     *
     */


    Transaction findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByIdDesc(
            Student student, Book book, TransactionType transactionType, TransactionStatus transactionStatus
    );
}
