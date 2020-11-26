package com.LinkedL.LLPractice;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}
