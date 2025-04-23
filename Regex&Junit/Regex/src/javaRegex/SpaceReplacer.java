package javaRegex;

import java.util.Scanner;

public class SpaceReplacer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = in.nextLine();

        String result = input.replaceAll("\\s+", " ");

        System.out.println("Result: " + result);

        in.close();
    }
}

