package main.exceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}