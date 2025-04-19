package collections;
import java.util.*;

public class Subset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.println("Enter number of elements in Set1:");
        int n1 = s.nextInt();
        System.out.println("Enter elements of Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(s.nextInt());
        }

        System.out.println("Enter number of elements in Set2:");
        int n2 = s.nextInt();
        System.out.println("Enter elements of Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(s.nextInt());
        }

        boolean isSubset = set2.containsAll(set1);
        System.out.println("Is Set1 a subset of Set2? " + isSubset);

        s.close();
    }
}
