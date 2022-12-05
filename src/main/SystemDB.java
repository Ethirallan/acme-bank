package main;

import main.exceptions.OverdraftLimitExceededException;

import java.util.HashMap;

public final class SystemDB {
    private static SystemDB INSTANCE;

    private HashMap<String, Account> accounts = new HashMap<>();

    private SystemDB() {
        accounts.put("1", new SavingsAccount(1, "1", 2000));
        accounts.put("2", new SavingsAccount(2,"2", 5000));
        try {
            accounts.put("3", new CurrentAccount(3,"3", 1000, 10000));
            accounts.put("4", new CurrentAccount(4, "4", -5000, 20000));
        } catch (OverdraftLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    public static SystemDB getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SystemDB();
        }
        return INSTANCE;
    }

    public void addAccount(Account account) {
        accounts.put(account.getCustomerNumber(), account);
    }

    public Account getAccount(String key) {
        return accounts.get(key);
    }
}