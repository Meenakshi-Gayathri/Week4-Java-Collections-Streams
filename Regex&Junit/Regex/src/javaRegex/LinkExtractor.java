package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class LinkExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text containing URLs: ");
        String text = in.nextLine();

        String regex = "\\bhttps?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9&%_.-]*)?\\b";  // Matches URLs starting with http:// or https://

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }

        if (!found) {
            System.out.println("No URLs found.");
        }

        in.close(); 
    }
}
