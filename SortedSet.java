package collections;
import java.util.*;

public class SortedSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        System.out.println("Enter the number of elements:");
        int n = s.nextInt();
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            set.add(s.nextInt());
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println("Sorted List: " + list);

        s.close();
    }
}
