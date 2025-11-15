package com.yourcompany.projectname.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class TransactionEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private double amount;
    private long date;

    public TransactionEntity(String title, double amount, long date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public long getDate() { return date; }
}
