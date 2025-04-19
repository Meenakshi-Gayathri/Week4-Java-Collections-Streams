package collections;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateElements {
	public static void rotateArrayList(ArrayList<Integer> al,int k) {
		int n = al.size();
		k = k%n;
		ArrayList<Integer> rotated = new ArrayList<>();
		for(int i =k;i<n;i++) {
			rotated.add(al.get(i));
		}
		for(int i=0;i<k;i++) {
			rotated.add(al.get(i));
		}
		for(int i=0;i<n;i++) {
			al.set(i,rotated.get(i));
		}
	}
	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 ArrayList<Integer> al = new ArrayList<>();
		 System.out.print("Enter the size of ArrayList: ");
		 int size = s.nextInt();
		 System.out.print("Enter the Elements: ");
		 for(int i=0;i<size;i++) {
			 al.add(s.nextInt());
		 }
		 System.out.print("Enter the position: ");
		 int k = s.nextInt();
		 rotateArrayList(al,k);
		 System.out.println(al);
		 s.close();
	 }

}
