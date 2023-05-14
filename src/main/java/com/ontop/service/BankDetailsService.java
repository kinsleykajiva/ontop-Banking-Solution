package com.ontop.service;

import com.ontop.domain.BankDetails;
import com.ontop.exceptions.InvalidBankDetailsException;
import com.ontop.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankDetailsService {

    private final BankDetailsRepository bankDetailsRepository;

    @Autowired
    public BankDetailsService(BankDetailsRepository bankDetailsRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
    }

    public BankDetails getBankDetailsByUserId(Long userId) {
        BankDetails bankDetails = bankDetailsRepository.findByUserId(userId);
        if (bankDetails == null) {
            throw new InvalidBankDetailsException("No bank details found for user with ID: " + userId);
        }
        return bankDetails;
    }
    public Optional<BankDetails> getBankDetailsById(Long bankId) {
        return bankDetailsRepository.findById(bankId);
    }

    public BankDetails saveBankDetails(BankDetails bankDetails) {
        return bankDetailsRepository.save(bankDetails);
    }

    public BankDetails update( BankDetails bankDetails) {

        bankDetails = bankDetailsRepository.save(bankDetails);
        return bankDetails;
    }

    public void delete(Long bankDetailsId) {
        var obj =bankDetailsRepository.findById(bankDetailsId);
        obj.ifPresent(bankDetailsRepository::delete);

    }
}