package javaexception;

public class ExceptionPropagation {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    public static void method1() {
        int result = 10 / 0;
    }

    public static void method2() {
        method1();
    }
}

