package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = in.nextLine();

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        if (Pattern.matches(regex, username)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        in.close();
    }
}


