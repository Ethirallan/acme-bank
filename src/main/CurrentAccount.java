package main;

import main.exceptions.OverdraftLimitExceededException;
import main.exceptions.WithdrawalAmountTooLargeException;

public class CurrentAccount extends Account {

    private double overdraft;
    private final double overdraftLimit = 100000;

    public CurrentAccount(int accountId, String customerNumber, double balance, double overdraft) throws OverdraftLimitExceededException {
        if (overdraft <= this.overdraftLimit) {
            this.setAccountId(accountId);
            this.setCustomerNumber(customerNumber);
            this.setBalance(balance);
            this.overdraft = overdraft;
        } else {
            throw new OverdraftLimitExceededException("Provided overdraft exceeds the limit " + overdraftLimit);
        }
    }

    @Override
    public void deposit(double amountToDeposit) {
        increaseBalance(amountToDeposit);
    }

    @Override
    public void withdraw(double amountToWithdraw) throws WithdrawalAmountTooLargeException {
        System.out.println(amountToWithdraw);
        System.out.println(overdraft);
        System.out.println(getBalance());
        System.out.println(amountToWithdraw <= overdraft + getBalance());
        if (amountToWithdraw <= overdraft + getBalance()) {
            decreaseBalance(amountToWithdraw);
        } else {
            throw new WithdrawalAmountTooLargeException("Withdrawal amount is too large!");
        }
    }

    @Override
    void calculateInterest(int accountId) {
        // TODO: implement
    }

    @Override
    void transfer(int destinationAccountId, double amountToTransfer) {
        // TODO: implement
    }
}
