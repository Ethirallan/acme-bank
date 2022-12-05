package main;

import main.exceptions.DepositAmountTooSmallException;
import main.exceptions.WithdrawalAmountTooLargeException;

public abstract class Account {
    private int accountId;
    private String customerNumber;
    private double balance;

    abstract void deposit(double amountToDeposit) throws DepositAmountTooSmallException;
    abstract void withdraw(double amountToWithdraw) throws WithdrawalAmountTooLargeException;
    abstract void calculateInterest(int accountId);
    abstract void transfer(int destinationAccountId, double amountToTransfer);

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void increaseBalance(double balance) {
        this.balance += balance;
    }

    public void decreaseBalance(double balance) {
        this.balance -= balance;
    }
}
