package collections;
import java.util.*;

public class ReverseQueue {
	public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.remove();
        reverse(queue);
        queue.add(front);
    }
	
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        System.out.println("Enter the number of elements:");
        int n = s.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            queue.add(s.nextInt());
        }

        reverse(queue);

        System.out.println("Reversed Queue: " + queue);
        s.close();
    }    
}
