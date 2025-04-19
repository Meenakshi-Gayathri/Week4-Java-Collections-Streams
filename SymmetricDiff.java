package collections;
import java.util.*;

public class SymmetricDiff {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        System.out.println("Enter the number of elements for Set A:");
        int n1 = s.nextInt();
        System.out.println("Enter elements for Set A:");
        for (int i = 0; i < n1; i++) {
            a.add(s.nextInt());
        }

        System.out.println("Enter the number of elements for Set B:");
        int n2 = s.nextInt();
        System.out.println("Enter elements for Set B:");
        for (int i = 0; i < n2; i++) {
            b.add(s.nextInt());
        }

        Set<Integer> diff = new HashSet<>(a);
        diff.addAll(b);

        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);

        diff.removeAll(intersection);

        System.out.println("Symmetric Difference: " + diff);

        s.close();
    }
}
