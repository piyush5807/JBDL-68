package org.geeksforgeeks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface WalletRepository extends JpaRepository<Wallet, String> {

    Wallet findByUserId(Integer userId);

    @Modifying
    @Transactional
    @Query("update Wallet w set w.balance = w.balance + :amount where w.id = :walletId")
    void incrementWallet(String walletId, Long amount);

    @Modifying
    @Transactional
    @Query("update Wallet w set w.balance = w.balance - :amount where w.id = :walletId")
    void decrementWallet(String walletId, Long amount);

    @Modifying
    @Transactional
    @Query("update Wallet w set w.balance = w.balance + :amount where w.id = :walletId")
    void updateWallet(String walletId, Long amount);
}
