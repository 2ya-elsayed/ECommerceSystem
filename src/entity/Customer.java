package entity;

import exception.BalanceException;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        setBalance(balance);
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw BalanceException.invalid(balance);
        }
        this.balance = balance;
    }

    public void deductBalance(double amount) {
        if (amount > balance) {
            throw BalanceException.insufficient(amount, balance);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return name + " - Balance: " + balance;
    }
}
