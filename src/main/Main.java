package main;

public class Main {
    public static void main(String[] args) {
        SystemDB systemDB = SystemDB.getInstance();
        AccountService accountService = new AccountService(systemDB);
        accountService.openSavingsAccount(5, 100000);
        accountService.openCurrentAccount(6, 100000, 20000);
        accountService.withdraw(5, 20000);
        accountService.withdraw(6, 20000);
        accountService.deposit(5, 2000);
        accountService.deposit(2, 2000);
    }
}
