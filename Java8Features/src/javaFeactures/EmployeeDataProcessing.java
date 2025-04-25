package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + department + " | $" + salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeDataProcessing {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            in.nextLine();
            String name = in.nextLine();
            String department = in.nextLine();
            double salary = in.nextDouble();
            in.nextLine();
            employees.add(new Employee(id, name, department, salary));
        }

        // 1. Filter
        List<Employee> filtered = employees.stream()
                .filter(e -> e.department.equalsIgnoreCase("Engineering") && e.salary > 80000)
                .collect(Collectors.toList());

        // 2. Sort by salary descending
        List<Employee> sorted = filtered.stream()
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .collect(Collectors.toList());

        // 3. Group by department
        Map<String, List<Employee>> grouped = sorted.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // 4. Average salary per department
        Map<String, Double> averageSalary = grouped.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(0)
                ));

        // Print Results
        grouped.forEach((dept, empList) -> {
            System.out.println("Department: " + dept);
            empList.forEach(System.out::println);
        });

        System.out.println("Average Salary by Department:");
        averageSalary.forEach((dept, avg) ->
                System.out.println(dept + ": $" + avg));
    }
}

