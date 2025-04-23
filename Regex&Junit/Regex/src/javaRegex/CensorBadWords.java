package javaRegex;

import java.util.*;

public class CensorBadWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = in.nextLine();

        List<String> badWords = Arrays.asList("damn", "stupid","mental","shit");  

        for (String badWord : badWords) {
            input = input.replaceAll("(?i)\\b" + badWord + "\\b", "****");
        }

        System.out.println("Censored sentence: " + input);

        in.close();
    }
}

