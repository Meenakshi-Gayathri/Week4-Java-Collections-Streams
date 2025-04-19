package collections;

import java.util.*;

class Employee {
    String name;
    String department;
    Employee(String name, String dept) {
        this.name = name;
        this.department = dept;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> deptMap = new HashMap<>();
        for (Employee emp : employees) {
            deptMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        for (Map.Entry<String, List<Employee>> entry : deptMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

