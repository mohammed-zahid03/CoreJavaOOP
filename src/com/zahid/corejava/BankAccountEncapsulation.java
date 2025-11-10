package com.zahid.corejava;

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        setAccountNumber(accountNumber);
        setHolderName(holderName);
        setBalance(balance);
    }

    // Encapsulation through getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.matches("\\d{6,10}")) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Invalid Account Number. Must be 6–10 digits.");
            this.accountNumber = "000000";
        }
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        if (holderName != null && !holderName.trim().isEmpty()) {
            this.holderName = holderName.trim();
        } else {
            this.holderName = "Unknown";
        }
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        if (balance >= 0)
            this.balance = balance;
        else
            this.balance = 0;
    }

    // Business logic (still encapsulated)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void printBalance() {
        System.out.println("Available Balance: ₹" + balance);
    }

    @Override
    public String toString() {
        return String.format("Account[%s, Holder='%s', Balance=₹%.2f]", accountNumber, holderName, balance);
    }
}

public class BankAccountEncapsulation {
    public static void main(String[] args) {
        System.out.println("=== Bank Account Encapsulation Demo ===\n");

        BankAccount acc1 = new BankAccount("123456", "Rahul Sharma", 5000);
        BankAccount acc2 = new BankAccount("abc12", "", -1000);

        System.out.println(acc1);
        System.out.println(acc2 + "\n");

        // Perform some operations
        acc1.deposit(1500);
        acc1.withdraw(2000);
        acc1.printBalance();

        acc2.deposit(500);
        acc2.withdraw(200);
        acc2.printBalance();

        System.out.println("\nFinal Account States:");
        System.out.println(acc1);
        System.out.println(acc2);
    }
}
