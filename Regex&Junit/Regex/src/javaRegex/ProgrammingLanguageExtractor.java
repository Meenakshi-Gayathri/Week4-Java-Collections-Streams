package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence mentioning programming languages: ");
        String text = in.nextLine();

        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|C#|Ruby|Swift|PHP|Kotlin|Rust|R)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
            found = true;
        }

        if (!found) {
            System.out.println("No programming languages found.");
        }

        in.close();
    }
}

