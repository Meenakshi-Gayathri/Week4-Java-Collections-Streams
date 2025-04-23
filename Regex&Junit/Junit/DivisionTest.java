import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    public static class Divider {
        public static int divide(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    }

    @Test
    public void testDivideNormal() {
        assertEquals(2, Divider.divide(10, 5));
        assertEquals(0, Divider.divide(0, 5));
        assertEquals(-2, Divider.divide(10, -5));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> Divider.divide(5, 0));
    }
}
