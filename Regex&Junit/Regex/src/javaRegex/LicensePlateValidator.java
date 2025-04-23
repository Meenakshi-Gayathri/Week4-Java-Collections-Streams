package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter license plate: ");
        String licensePlate = in.nextLine();

        String regex = "^[A-Z]{2}\\d{4}$";
        if (Pattern.matches(regex, licensePlate)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }

        in.close();
    }
}

