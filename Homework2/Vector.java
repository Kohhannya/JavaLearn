package Homework2;

import java.io.Serializable;
import java.util.Scanner;
/** @author Kohhannya
 * @version 3.0
 */
public class Vector implements Serializable {

    /** fields, which store coordinates of the vector */
    private double x, y, z;

    /**
     * This is constructor
     * @param inputX - x
     * @param inputY - y
     * @param inputZ - z
     * @since 1.0
     */
    public Vector(double inputX, double inputY, double inputZ) {
        x = inputX;
        y = inputY;
        z = inputZ;
    }

    /** Функция получения значения поля {@link Vector#x}
     * @return возвращает координату по оси X
     */
    public double getX() {
        return x;
    }

    /** Функция получения значения поля {@link Vector#y}
     * @return возвращает координату по оси Y
     */
    public double getY() {
        return y;
    }

    /** Функция получения значения поля {@link Vector#z}
     * @return возвращает координату по оси Z
     */
    public double getZ() {
        return z;
    }

    /** Функция сравнения двух объектов типа Vector */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        double eps = 0.0001; //критерий точности
        return Math.abs(x - vector.x) < eps && Math.abs(y - vector.y) < eps && Math.abs(z - vector.z) < eps;
    }

    /**
     * @return возвращает хеш объекта
     */
    public int hashCode() {
        int newX = (int) (x * 1000);
        int newY = (int) (y * 1000);
        int newZ = (int) (z * 1000);

        return newX * 10000 + newY * 100 + newZ; //Позволяет закодировать куб с ребром 100 без коллизий
    }

    /**
     * @return возращает вектор в виде строки
     */
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")" + "\r\n";
    }

    /**
     * @return возращает длину вектора
     */
    public double length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * @return возращает скалярное произведение векторов
     */
    public double scalarProduct(Vector vector){
        return x * vector.x + y * vector.y + z * vector.z;
    }

    /**
     * @return возращает векторное произведение векторов
     */
    public Vector crossProduct(Vector vector){
        double newX = y * vector.z - z * vector.y;
        double newY = z * vector.x - x * vector.z;
        double newZ = x * vector.y - y * vector.x;
        return new Vector(newX, newY, newZ);
    }

    /**
     * @return возращает косинус между двумя векторами
     */
    public double cos(Vector vector){
        return this.scalarProduct(vector) / this.length() / vector.length();
    }

    /**
     * @return возращает сумму двух векторов
     */
    public Vector add(Vector vector){
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    /**
     * @return возращает разность двух векторов
     */
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