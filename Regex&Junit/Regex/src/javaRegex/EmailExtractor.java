package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class EmailExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text containing email(s): ");
        String text = in.nextLine();

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Found email: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No email addresses found.");
        }

        in.close();
    }
}

