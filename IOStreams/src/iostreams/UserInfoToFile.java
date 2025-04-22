package iostreams;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInfoToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your name: ");
            String name = br.readLine();
            
            System.out.print("Enter your age: ");
            String age = br.readLine();
            
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            try (FileWriter writer = new FileWriter("userInfo.txt")) {
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Favorite Programming Language: " + language + "\n");
            }
            System.out.println("Information saved to userInfo.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

