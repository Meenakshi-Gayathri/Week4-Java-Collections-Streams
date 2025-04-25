package javaFeactures;

import java.util.Scanner;
import java.util.function.Function;

public class CircleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double radius = in.nextDouble();
        Function<Double, Double> area = r -> Math.PI * r * r;
        System.out.println(area.apply(radius));
    }
}

