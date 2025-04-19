package collections;

import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        System.out.print("Enter the number of patients: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();

            System.out.print("Enter severity (higher means more critical): ");
            int severity = scanner.nextInt();
            scanner.nextLine();

            triageQueue.add(new Patient(name, severity));
        }

        System.out.println("\nOrder of treatment based on severity:");
        while (!triageQueue.isEmpty()) {
            Patient p = triageQueue.poll();
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
        scanner.close();
    }
}

