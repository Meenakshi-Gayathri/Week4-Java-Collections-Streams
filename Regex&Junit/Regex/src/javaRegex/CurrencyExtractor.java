package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text containing currency values: ");
        String text = in.nextLine();

        String regex = "\\$?\\d+(\\.\\d{2})?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }

        in.close();
    }
}

