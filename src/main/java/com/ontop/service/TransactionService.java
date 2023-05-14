package com.ontop.service;

import com.ontop.domain.BankDetails;
import com.ontop.domain.Transaction;
import com.ontop.domain.User;
import com.ontop.exceptions.InsufficientBalanceException;
import com.ontop.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Transactional
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final BankDetailsService bankDetailsService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserService userService,
                              BankDetailsService bankDetailsService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.bankDetailsService = bankDetailsService;
    }


    public Transaction makeTransaction(Long userId, BigDecimal amount) {
        User user = userService.getUserById(userId);
        BankDetails bankDetails = bankDetailsService.getBankDetailsByUserId(userId);

        if (user.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance for user with ID: " + userId);
        }

        BigDecimal fee = amount.multiply(BigDecimal.valueOf(0.1));
        BigDecimal totalAmount = amount.add(fee);

       // user.setBalance(user.getBalance().subtract(totalAmount));
        userService.updateUser(user);

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setRecipientFirstName(user.getFirstName());
        transaction.setRecipientLastName(user.getLastName());
        transaction.setRoutingNumber(bankDetails.getRoutingNumber());
        transaction.setAccountNumber(bankDetails.getAccountNumber());
        transaction.setAmount(amount);
        transaction.setFees(fee);
        transaction.setRecipientGetAmount(amount);
        transaction.setTransactionDate(null);
        transaction.setStatus("COMPLETED");

        return transactionRepository.save(transaction);
    }

    public Transaction withdraw(Long userId, double amount) {

        return  null;
    }

    public Transaction transfer(Long userId, double amount, Long bankDetailsId) {
        return null;
    }
}
