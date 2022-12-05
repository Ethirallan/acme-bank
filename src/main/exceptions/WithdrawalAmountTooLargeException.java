package main.exceptions;

public class WithdrawalAmountTooLargeException extends Exception {
    public WithdrawalAmountTooLargeException(String errorMessage) {
        super(errorMessage);
    }
}