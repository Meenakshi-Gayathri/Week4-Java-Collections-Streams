import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BankAccountTest {

    public static class BankAccount {
        private double balance = 0.0;

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testDepositIncreasesBalance() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    public void testWithdrawFailsIfInsufficientFunds() {
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    public void testInitialBalanceIsZero() {
        assertEquals(0.0, account.getBalance());
    }
}
