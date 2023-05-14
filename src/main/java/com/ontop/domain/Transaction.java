package com.ontop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity @Getter
@Setter
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "recipient_first_name", nullable = false)
    private String recipientFirstName;

    @Column(name = "recipient_last_name", nullable = false)
    private String recipientLastName;

    @Column(name = "routing_number", nullable = false)
    private String routingNumber;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "fees", nullable = false)
    private BigDecimal fees;

    @Column(name = "recipient_get_amount", nullable = false)
    private BigDecimal recipientGetAmount;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    public Transaction() {
        this.transactionDate = new Date();
    }
    public Transaction(User user, String recipientFirstName, String recipientLastName, String routingNumber,
                       String accountNumber, BigDecimal amount, BigDecimal fees, BigDecimal recipientGetAmount) {
        this.user = user;
        this.recipientFirstName = recipientFirstName;
        this.recipientLastName = recipientLastName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.fees = fees;
        this.recipientGetAmount = recipientGetAmount;
        this.transactionDate = new Date();
    }


    public void setStatus(String completed) {


    }
}
