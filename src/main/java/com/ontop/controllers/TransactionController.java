package com.ontop.controllers;

import com.ontop.domain.Transaction;
import com.ontop.exceptions.InsufficientBalanceException;
import com.ontop.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{userId}/withdraw")
    public ResponseEntity<Transaction> withdraw(@PathVariable Long userId, @RequestParam double amount) {
        Transaction transaction = transactionService.withdraw(userId, amount);
        if (transaction == null) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}/transfer")
    public ResponseEntity<Transaction> transfer(@PathVariable Long userId, @RequestParam double amount, @RequestParam Long bankDetailsId) {
        Transaction transaction = transactionService.transfer(userId, amount, bankDetailsId);
        if (transaction == null) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
