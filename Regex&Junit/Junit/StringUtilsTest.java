import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    public static class StringUtils {
        public static String reverse(String str) {
            return new StringBuilder(str).reverse().toString();
        }

        public static boolean isPalindrome(String str) {
            String reversed = reverse(str);
            return str.equals(reversed);
        }

        public static String toUpperCase(String str) {
            return str.toUpperCase();
        }
    }

    @Test
    public void testReverse() {
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("a", StringUtils.reverse("a"));
        assertEquals("racecar", StringUtils.reverse("racecar"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertTrue(StringUtils.isPalindrome("a"));
        assertTrue(StringUtils.isPalindrome(""));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("JAVA", StringUtils.toUpperCase("Java"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertEquals("123!@#", StringUtils.toUpperCase("123!@#"));
    }
}
