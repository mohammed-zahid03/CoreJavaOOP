package com.zahid.corejava;

// Abstract parent class
abstract class AbstractBankAccount {
    protected String accountNumber;
    protected double balance;

    public AbstractBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = Math.max(balance, 0);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract method → must be implemented by all subclasses
    public abstract void withdraw(double amount);

    public void printBalance() {
        System.out.println("Balance: ₹" + balance);
    }
}

// Savings account with min balance rule
class SavingsAcc extends AbstractBankAccount {

    private final double MIN_BALANCE = 500;

    public SavingsAcc(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Savings Withdrawal: ₹" + amount);
        } else {
            System.out.println("Savings Account: Maintain minimum balance ₹" + MIN_BALANCE);
        }
    }
}

// Current account with no minimum balance
class CurrentAcc extends AbstractBankAccount {

    public CurrentAcc(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Current Withdrawal: ₹" + amount);
        } else {
            System.out.println("Insufficient funds in Current Account.");
        }
    }
}

public class AbstractAccountDemo {
    public static void main(String[] args) {

        AbstractBankAccount acc1 = new SavingsAcc("SA101", 5000);
        AbstractBankAccount acc2 = new CurrentAcc("CA202", 15000);

        System.out.println("=== Savings Account ===");
        acc1.deposit(1000);
        acc1.withdraw(5500);
        acc1.printBalance();

        System.out.println("\n=== Current Account ===");
        acc2.deposit(2000);
        acc2.withdraw(17000);
        acc2.printBalance();
    }
}
