import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PasswordValidatorTest {

    public boolean validate(String password) {
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        return true;
    }

    @Test
    public void testValidPassword() {
        PasswordValidatorTest pv = new PasswordValidatorTest();
        Assertions.assertTrue(pv.validate("Valid1Password"));
    }

    @Test
    public void testShortPassword() {
        PasswordValidatorTest pv = new PasswordValidatorTest();
        Assertions.assertFalse(pv.validate("Short1"));
    }

    @Test
    public void testNoUppercase() {
        PasswordValidatorTest pv = new PasswordValidatorTest();
        Assertions.assertFalse(pv.validate("nouppercase1"));
    }

    @Test
    public void testNoDigit() {
        PasswordValidatorTest pv = new PasswordValidatorTest();
        Assertions.assertFalse(pv.validate("NoDigitPassword"));
    }
}