package collections;

public class CircularBuffer {
    public static void main(String[] args) {
        int size = 3;
        int[] buffer = new int[size];
        int start = 0;
        int end = 0;
        int count = 0;

        int[] inputs = {1, 2, 3, 4};

        for (int val : inputs) {
            buffer[end] = val;
            end = (end + 1) % size;
            if (count < size) {
                count++;
            } else {
                start = (start + 1) % size;
            }
        }

        System.out.print("Final Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (start + i) % size;
            System.out.print(buffer[index]);
            if (i != count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
