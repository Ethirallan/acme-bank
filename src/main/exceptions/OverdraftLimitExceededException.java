package main.exceptions;

public class OverdraftLimitExceededException extends Exception {
    public OverdraftLimitExceededException(String errorMessage) {
        super(errorMessage);
    }
}