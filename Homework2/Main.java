package Homework2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        Vector a = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());
        Vector b = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());

        System.out.println("Длина а = " + a.length() + "\r\n");
        System.out.println("Длина b = " + b.length() + "\r\n");

        System.out.println("(a, b) = " + a.scalarProduct(b) + "\r\n");

        System.out.print("a x b = ");
        a.crossProduct(b).printVector();

        System.out.println("cos угла между a и b = " + a.cos(b) + "\r\n");

        System.out.print("a + b = ");
        a.add(b).printVector();

        System.out.print("a - b = ");
        a.subtract(b).printVector();
    }
}
