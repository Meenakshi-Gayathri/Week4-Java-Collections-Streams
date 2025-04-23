package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class DateExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text containing dates: ");
        String text = in.nextLine();

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b"; 

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }

        if (!found) {
            System.out.println("No dates found.");
        }

        in.close(); 
    }
}
