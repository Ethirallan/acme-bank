package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.SavingsAccount;
import main.exceptions.DepositAmountTooSmallException;
import main.exceptions.WithdrawalAmountTooLargeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

    SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount(1, "1", 20000);
    }

    @Test
    @DisplayName("Test deposit open")
    void testDepositOpen() {
        try {
            account.deposit(1000);
        } catch (DepositAmountTooSmallException e) {
            System.out.println(e);
        }
        assertEquals(21000, account.getBalance());
    }

    @Test
    @DisplayName("Test deposit closed")
    void testDepositCloser() {
        SavingsAccount acc = new SavingsAccount(2, "2", 500);
        try {
            acc.deposit(1000);
        } catch (DepositAmountTooSmallException e) {
            System.out.println(e);
        }
        assertEquals(1000, acc.getBalance());
    }

    @Test
    @DisplayName("Test deposit exception")
    void testDepositException() {
        assertThrows(DepositAmountTooSmallException.class, () ->
                new SavingsAccount(3, "3", 500).deposit(200));
    }

    @Test
    @DisplayName("Test withdrawal")
    void testWithdraw() {
        try {
            account.withdraw(1000);
        } catch (WithdrawalAmountTooLargeException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(19000, account.getBalance());
    }

    @Test
    @DisplayName("Test withdrawal exception")
    void testWithdrawException() {
        assertThrows(WithdrawalAmountTooLargeException.class, () ->
                account.withdraw(1000000));
    }
}