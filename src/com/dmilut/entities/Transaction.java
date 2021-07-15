package com.dmilut.entities;

import com.dmilut.Storage;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {
    private long id;
    private TransactionType type;
    private double amount;
    private final Timestamp timestamp;
    private String purpose;

    public Transaction(TransactionType type, double amount) {
        id = Storage.getNewTransactionId();
        this.type = type;
        this.amount = amount;
        timestamp = Timestamp.valueOf(LocalDateTime.now());
    }

    public long getId() {
        return id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
