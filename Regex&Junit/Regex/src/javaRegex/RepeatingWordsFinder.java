package javaRegex;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = in.nextLine();

        String regex = "\\b(\\w+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Set<String> words = new HashSet<>();
        Set<String> repeatingWords = new HashSet<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (!words.add(word)) {
                repeatingWords.add(word);
            }
        }

        System.out.println(String.join(", ", repeatingWords));
        in.close();
    }
}

