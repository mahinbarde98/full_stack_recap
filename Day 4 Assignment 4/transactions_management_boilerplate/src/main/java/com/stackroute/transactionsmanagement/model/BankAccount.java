package com.stackroute.transactionsmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private double balance;

    public BankAccount(Long id, String accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
// Constructors, getters, setters
}

