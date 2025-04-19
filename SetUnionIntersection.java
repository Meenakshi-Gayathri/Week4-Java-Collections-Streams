package collections;
import java.util.*;

public class SetUnionIntersection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> a = new HashSet<Integer>();
        Set<Integer> b = new HashSet<Integer>();

        System.out.println("Enter the number of elements for Set A:");
        int n1 = sc.nextInt();
        System.out.println("Enter elements for Set A:");
        for (int i = 0; i < n1; i++) {
            a.add(sc.nextInt());
        }

        System.out.println("Enter the number of elements for Set B:");
        int n2 = sc.nextInt();
        System.out.println("Enter elements for Set B:");
        for (int i = 0; i < n2; i++) {
            b.add(sc.nextInt());
        }

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);

        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);

        System.out.println("Union of Sets: " + union);
        System.out.println("Intersection of Sets: " + intersection);

        sc.close();
    }
}
