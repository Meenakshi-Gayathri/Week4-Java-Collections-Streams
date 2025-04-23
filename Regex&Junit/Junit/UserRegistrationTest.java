import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class UserRegistrationTest {

    public static class UserRegistration {
        public static void registerUser(String username, String email, String password) {
            if (username == null || username.isEmpty()) {
                throw new IllegalArgumentException("Username is required");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email format");
            }
            if (password == null || password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 8 characters");
            }
        }
    }

    @Test
    public void testValidUserRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("user1", "user1@example.com", "password123"));
        assertDoesNotThrow(() -> UserRegistration.registerUser("john_doe", "john.doe@example.com", "securepassword"));
    }

    @Test
    public void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "user1@example.com", "password123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser(null, "user1@example.com", "password123"));
    }

    @Test
    public void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("user1", "user1example.com", "password123"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("user1", null, "password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("user1", "user1@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("user1", "user1@example.com", null));
    }
}
