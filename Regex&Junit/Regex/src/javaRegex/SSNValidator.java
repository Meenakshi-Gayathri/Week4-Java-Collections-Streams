package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter SSN: ");
        String ssn = in.nextLine();

        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        if (Pattern.matches(regex, ssn)) {
            System.out.println("\"" + ssn + "\" is valid");
        } else {
            System.out.println("\"" + ssn + "\" is invalid");
        }

        in.close();
    }
}

