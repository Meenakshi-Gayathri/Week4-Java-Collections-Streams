import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {

    public static class Task {
        public static String longRunningTask() throws InterruptedException {
            Thread.sleep(1000);
            return "done";
        }
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    public void testLongRunningTaskTimeout() throws InterruptedException {
        Task.longRunningTask();
    }
}
