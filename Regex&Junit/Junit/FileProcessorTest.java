import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

public class FileProcessorTest {

    public static class FileProcessor {
        public static void writeToFile(String filename, String content) throws IOException {
            Files.write(Paths.get(filename), content.getBytes());
        }

        public static String readFromFile(String filename) throws IOException {
            return new String(Files.readAllBytes(Paths.get(filename)));
        }
    }

    private final String testFile = "testfile.txt";

    @AfterEach
    public void cleanUp() throws IOException {
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        String content = "Hello, file!";
        FileProcessor.writeToFile(testFile, content);
        String readContent = FileProcessor.readFromFile(testFile);
        assertEquals(content, readContent);
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        FileProcessor.writeToFile(testFile, "Test content");
        assertTrue(Files.exists(Paths.get(testFile)));
    }

    @Test
    public void testReadNonExistentFileThrowsException() {
        assertThrows(IOException.class, () -> FileProcessor.readFromFile("nonexistent.txt"));
    }
}
