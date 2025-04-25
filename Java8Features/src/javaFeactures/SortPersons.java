package javaFeactures;

import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class SortPersons {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String name = in.nextLine();
            int age = in.nextInt();
            double salary = in.nextDouble();
            in.nextLine();
            people.add(new Person(name, age, salary));
        }
        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));
        for (Person p : people) System.out.println(p.name + " " + p.age + " " + p.salary);
    }
}

