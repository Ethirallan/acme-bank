package main;

import main.exceptions.DepositAmountTooSmallException;
import main.exceptions.WithdrawalAmountTooLargeException;

public class SavingsAccount extends Account {

    private boolean isAccountOpen;
    private final double minBalance = 1000;

    public SavingsAccount(int accountId, String customerNumber, double balance) {
        setAccountId(accountId);
        setCustomerNumber(customerNumber);
        if (balance >= minBalance) {
            setBalance(balance);
            isAccountOpen = true;
        } else {
            setBalance(0);
            isAccountOpen = false;
        }
    }

    @Override
    public void deposit(double amountToDeposit) throws DepositAmountTooSmallException {
        if (this.isAccountOpen) {
            increaseBalance(amountToDeposit);
        } else {
            if (amountToDeposit >= minBalance) {
               isAccountOpen = true;
               increaseBalance(amountToDeposit);
            } else {
                throw new DepositAmountTooSmallException("Deposited amount is below min limit: " + minBalance);
            }
        }
    }

    @Override
    public void withdraw(double amountToWithdraw) throws WithdrawalAmountTooLargeException {
        if (amountToWithdraw <= getBalance() - minBalance) {
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