package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = in.nextLine();

        String regex = "\\b[A-Z][a-z]*\\b";  // Matches words starting with a capital letter

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }

        if (!found) {
            System.out.println("No capitalized words found.");
        }

        in.close();
    }
}

