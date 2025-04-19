package collections;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by space:");
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        
        List<Integer> inputList = new ArrayList<>();
        for (String part : parts) {
            inputList.add(Integer.parseInt(part));
        }

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : inputList) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }

        System.out.println("List after removing duplicates:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
