package collections;
import java.util.*;

public class CheckSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> h_set1 = new HashSet<Integer>();
        HashSet<Integer> h_set2 = new HashSet<Integer>();

        System.out.println("Enter number of elements for h_set1:");
        int n1 = sc.nextInt();
        System.out.println("Enter elements for h_set1:");
        for (int i = 0; i < n1; i++) {
            h_set1.add(sc.nextInt());
        }

        System.out.println("Enter number of elements for h_set2:");
        int n2 = sc.nextInt();
        System.out.println("Enter elements for h_set2:");
        for (int i = 0; i < n2; i++) {
            h_set2.add(sc.nextInt());
        }

        for (Integer element : h_set1) {
            System.out.println(h_set2.contains(element) ? "true" : "false");
        }

        sc.close();
    }
}
