package main;

import main.exceptions.DepositAmountTooSmallException;
import main.exceptions.OverdraftLimitExceededException;
import main.exceptions.WithdrawalAmountTooLargeException;

public class AccountService {
    private SystemDB systemDB;

    public AccountService(SystemDB systemDB) {
        this.systemDB = systemDB;
    }

    public void openSavingsAccount(int accountId, double amountToDeposit) {
        systemDB.addAccount(new SavingsAccount(accountId, String.valueOf(accountId), amountToDeposit));
    }

    public void openCurrentAccount(int accountId, double amountToDeposit, double overdraft) {
        try {
            systemDB.addAccount(new CurrentAccount(accountId, String.valueOf(accountId), amountToDeposit, overdraft));
        } catch (OverdraftLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(int accountId, double amountToWithdraw) {
        try {
            systemDB.getAccount(String.valueOf(accountId)).withdraw(amountToWithdraw);
        } catch (WithdrawalAmountTooLargeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deposit(int accountId, double amountToDeposit) {
        try {
            systemDB.getAccount(String.valueOf(accountId)).deposit(amountToDeposit);
        } catch (DepositAmountTooSmallException e) {
            System.out.println(e.getMessage());
        }
    }
}
