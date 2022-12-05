package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.CurrentAccount;
import main.exceptions.OverdraftLimitExceededException;
import main.exceptions.WithdrawalAmountTooLargeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {

    CurrentAccount account;

    @BeforeEach
    void setUp() {
        try {
            account = new CurrentAccount(1, "1", 0, 1000);
        } catch (OverdraftLimitExceededException e) {
            System.out.println(e);
        }
    }

    @Test
    @DisplayName("Test overdraft exception")
    void testOverdraftException() {
        assertThrows(OverdraftLimitExceededException.class, () ->
                new CurrentAccount(2, "2", 0, 100000000));
    }

    @Test
    @DisplayName("Test deposit positive")
    void testDepositPositive() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    @DisplayName("Test deposit negative")
    void testDepositNegative() {
        account.deposit(-5000);
        assertEquals(-5000, account.getBalance());
    }

    @Test
    @DisplayName("Test withdrawal")
    void testWithdraw() {
        try {
            account.withdraw(500);
        } catch (WithdrawalAmountTooLargeException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(-500, account.getBalance());
    }

    @Test
    @DisplayName("Test withdrawal exception")
    void testWithdrawException() {
        assertThrows(WithdrawalAmountTooLargeException.class, () ->
                account.withdraw(2000));
    }
}