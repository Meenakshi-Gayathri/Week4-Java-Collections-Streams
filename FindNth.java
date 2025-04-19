package collections;

import java.util.*;

public class FindNth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter elements separated by space:");
        String[] elements = sc.nextLine().split(" ");
        Collections.addAll(list, elements);

        System.out.print("Enter N (position from end): ");
        int n = sc.nextInt();

        String result = findNthFromEnd(list, n);
        if (result != null) {
            System.out.println("Nth element from the end: " + result);
        } else {
            System.out.println("Invalid value of N");
        }

        sc.close();
    }

    public static String findNthFromEnd(LinkedList<String> list, int n) {
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) return null;
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.hasNext() ? second.next() : null;
    }
}

