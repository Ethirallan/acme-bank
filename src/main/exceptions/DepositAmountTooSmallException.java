package main.exceptions;

public class DepositAmountTooSmallException extends Exception {
    public DepositAmountTooSmallException(String errorMessage) {
        super(errorMessage);
    }
}