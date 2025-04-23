import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    public static class DatabaseConnection {
        private boolean connected = false;

        public void connect() {
            connected = true;
        }

        public void disconnect() {
            connected = false;
        }

        public boolean isConnected() {
            return connected;
        }
    }

    private DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    public void testConnectionIsClosedAfterEach() {
        assertTrue(db.isConnected());
    }
}
