package Homework2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        Vector a = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());
        Vector b = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());

        System.out.println("Длина а = " + a.length());
        System.out.println("Длина b = " + b.length());

        System.out.println("(a, b) = " + a.scalarProduct(b));

        System.out.println("a x b = " + a.crossProduct(b).toString());

        System.out.println("cos угла между a и b = " + a.cos(b));

        System.out.println("a + b = " + a.add(b).toString());

        System.out.println("a - b = " + a.subtract(b).toString());

        System.out.println("Хеш а: " + a.hashCode());
        System.out.println("Хеш b: " + b.hashCode());

        System.out.println("Результат equals: " + a.equals(b));
    }
}
