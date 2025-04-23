import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenNumberTest {

    public static class NumberUtils {
        public static boolean isEven(int number) {
            return number % 2 == 0;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number));
    }
}
