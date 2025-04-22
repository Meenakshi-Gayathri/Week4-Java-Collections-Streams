package iostreams;

import java.io.*;

public class ConvertUppercaseToLowercase {
    public static void main(String[] args) {
        String sourceFile = "sourceFile.txt";
        String destinationFile = "destinationFile.txt";

        try (
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))
        ) {
            int character;
            while ((character = br.read()) != -1) {
                bw.write(Character.toLowerCase(character));
            }
            System.out.println("File conversion complete: Uppercase to lowercase.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

