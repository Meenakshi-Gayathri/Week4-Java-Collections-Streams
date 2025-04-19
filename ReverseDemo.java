package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseDemo{
    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void reverseLinkedList(LinkedList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the size of the lists: ");
        int size = s.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            int n = s.nextInt();
            arrayList.add(n);
            linkedList.add(n);
        }

        reverseArrayList(arrayList);
        reverseLinkedList(linkedList);

        System.out.println("Reversed ArrayList: " + arrayList);
        System.out.println("Reversed LinkedList: " + linkedList);

        s.close();
    }
}
