package iostreams;

import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "studentDetails.dat";

        // Writing binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            Student student = new Student(1, "Alice", 3.8);
            dos.writeInt(student.rollNumber);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);

            student = new Student(2, "Bob", 3.6);
            dos.writeInt(student.rollNumber);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);

            System.out.println("Student details saved to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }

        // Reading binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }
    }
}

