package iostreams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOPractice {
    public static void main(String[] args) {
        // Specify the file location (this will create the file in your project directory)
        String fileName = "practiceFile.txt";
        File file = new File(fileName);

        try {
            // Create a FileWriter object to write data to the file
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            // Write some text to the file
            bw.write("Hello, this is a test file!");
            bw.newLine();  // Add a new line
            bw.write("This is the second line of the file.");

            // Close the BufferedWriter to save the changes
            bw.close();
            
            System.out.println("File created and written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

