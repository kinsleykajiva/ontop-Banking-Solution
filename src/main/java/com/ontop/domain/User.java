package com.ontop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String nationalIDNumber;
    @Column(nullable = true)
    private String address;
    @Column(nullable = true)
    private String countryIso;


    public User() {
    }


    public User(Long id, String firstName, String lastName, String nationalIDNumber, String address, String countryIso) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIDNumber = nationalIDNumber;
        this.address = address;
        this.countryIso = countryIso;
    }

    public BigDecimal getBalance() {
        return null;
    }


}
