package iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBufferedStreams {
    public static void main(String[] args) {
        String sourceFileName = "practiceFile.txt";
        String destFileNameBuffered = "copiedBufferedFile.txt";
        String destFileNameUnbuffered = "copiedUnbufferedFile.txt";
        int bufferSize = 4096;

        try {
            long startTime, endTime;

            // Using Buffered Streams
            startTime = System.nanoTime();
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFileName));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFileNameBuffered))) {
                byte[] buffer = new byte[bufferSize];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }
            endTime = System.nanoTime();
            System.out.println("Buffered Streams Time: " + (endTime - startTime) + " nanoseconds");

            startTime = System.nanoTime();
            try (FileInputStream fis = new FileInputStream(sourceFileName);
                 FileOutputStream fos = new FileOutputStream(destFileNameUnbuffered)) {
                int data;
                while ((data = fis.read()) != -1) {
                    fos.write(data);
                }
            }
            endTime = System.nanoTime();
            System.out.println("Unbuffered Streams Time: " + (endTime - startTime) + " nanoseconds");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
