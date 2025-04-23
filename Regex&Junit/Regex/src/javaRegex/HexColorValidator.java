package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter hex color code: ");
        String colorCode = in.nextLine();

        String regex = "^#[0-9A-Fa-f]{6}$";
        if (Pattern.matches(regex, colorCode)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        in.close();
    }
}

