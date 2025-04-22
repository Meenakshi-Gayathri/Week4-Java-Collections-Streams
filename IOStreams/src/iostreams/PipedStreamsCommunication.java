package iostreams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            pos.write(message.getBytes());
            pos.close();
            System.out.println("WriterThread: Data written to pipe.");
        } catch (IOException e) {
            System.out.println("WriterThread Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
            pis.close();
            System.out.println("ReaderThread: Data read from pipe.");
        } catch (IOException e) {
            System.out.println("ReaderThread Error: " + e.getMessage());
        }
    }
}

public class PipedStreamsCommunication {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        try {
            pos.connect(pis);

            Thread writer = new WriterThread(pos);
            Thread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main Error: " + e.getMessage());
        }
    }
}

