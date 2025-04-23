package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        String cardNumber = in.nextLine();

        String regex = "^(4\\d{15}|5\\d{15})$";

        if (Pattern.matches(regex, cardNumber)) {
            System.out.println("Valid credit card number");
        } else {
            System.out.println("Invalid credit card number");
        }

        in.close();
    }
}

