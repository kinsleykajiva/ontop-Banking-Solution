package com.ontop.repository;

import com.ontop.domain.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {

    BankDetails findByUserId(Long userId);

}