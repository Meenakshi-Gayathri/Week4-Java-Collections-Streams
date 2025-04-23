package javaRegex;

import java.util.Scanner;
import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ipAddress = in.nextLine();

        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
                     + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        if (Pattern.matches(regex, ipAddress)) {
            System.out.println("Valid IP address");
        } else {
            System.out.println("Invalid IP address");
        }

        in.close();
    }
}
