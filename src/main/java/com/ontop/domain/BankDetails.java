package com.ontop.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Getter @Setter
@Entity
@Table(name = "bank_details")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "bank_name")
    private String bankName;

    @NotBlank
    @Size(max = 255)
    @Column(name = "routing_number")
    private String routingNumber;

    @NotBlank
    @Size(max = 255)
    @Column(name = "account_number")
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public BankDetails() {}

    public BankDetails(String bankName, String routingNumber, String accountNumber, User user) {
        this.bankName = bankName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.user = user;
    }
}
