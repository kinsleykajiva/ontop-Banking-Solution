package com.ontop.controllers;


import com.ontop.domain.BankDetails;
import com.ontop.exceptions.BankDetailsNotFoundException;
import com.ontop.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankdetails")
public class BankDetailsController {
    private final BankDetailsService bankDetailsService;

    @Autowired
    public BankDetailsController(BankDetailsService bankDetailsService) {
        this.bankDetailsService = bankDetailsService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<BankDetails> create(@PathVariable Long userId, @RequestBody BankDetails bankDetails) {
        BankDetails createdBankDetails = bankDetailsService.saveBankDetails( bankDetails);
        return new ResponseEntity<>(createdBankDetails, HttpStatus.CREATED);
    }

    @GetMapping("/{bankDetailsId}")
    public ResponseEntity<BankDetails> getById(@PathVariable Long bankDetailsId) {
        BankDetails bankDetails = bankDetailsService.getBankDetailsByUserId(bankDetailsId);
        if (bankDetails == null) {
            throw new BankDetailsNotFoundException("Bank details not found with ID: " + bankDetailsId);
        }
        return new ResponseEntity<>(bankDetails, HttpStatus.OK);
    }

    @PutMapping("/{bankDetailsId}")
    public ResponseEntity<BankDetails> update(@PathVariable Long bankDetailsId, @RequestBody BankDetails bankDetails) {
        BankDetails updatedBankDetails = bankDetailsService.update(bankDetails);
        if (updatedBankDetails == null) {
            throw new BankDetailsNotFoundException("Bank details not found with ID: " + bankDetailsId);
        }
        return new ResponseEntity<>(updatedBankDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{bankDetailsId}")
    public ResponseEntity<Void> delete(@PathVariable Long bankDetailsId) {
        bankDetailsService.delete(bankDetailsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
