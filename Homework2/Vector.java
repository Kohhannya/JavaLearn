package Homework2;

import java.util.Scanner;

public class Vector {
    private double x, y, z;

    public Vector(double inputX, double inputY, double inputZ) {
        x = inputX;
        y = inputY;
        z = inputZ;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        double eps = 0.0001; //критерий точности
        return Math.abs(x - vector.x) < eps && Math.abs(y - vector.y) < eps && Math.abs(z - vector.z) < eps;
    }

    public int hashCode() {
        int newX = (int) (x * 1000);
        int newY = (int) (y * 1000);
        int newZ = (int) (z * 1000);

        return newX * 10000 + newY * 100 + newZ; //Позволяет закодировать куб с ребром 100 без коллизий
    }
    /*  На случай, я неправильно написала собственный хеш...

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
     */

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")" + "\r\n";
    }

    // Длина вектора. Корень из суммы квадратов
    public double length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    // метод, вычисляющий скалярное произведение
    public double scalarProduct(Vector vector){
        return x * vector.x + y * vector.y + z * vector.z;
    }

    // метод, вычисляющий векторное произведение
    public Vector crossProduct(Vector vector){
        double newX = y * vector.z - z * vector.y;
        double newY = z * vector.x - x * vector.z;
        double newZ = x * vector.y - y * vector.x;
        return new Vector(newX, newY, newZ);
    }

    // Косинус между двумя векторами
    public double cos(Vector vector){
        return this.scalarProduct(vector) / this.length() / vector.length();
    }

    // Сумма двух векторов
    public Vector add(Vector vector){
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    // Разность двух веkторов
    public Vector subtract(Vector vector){
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        Vector a = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());
        Vector b = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());

        System.out.println("Задача 1: Класс вектор\r\n");
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