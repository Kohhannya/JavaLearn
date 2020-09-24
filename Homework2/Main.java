package Homework2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

//        Vector a = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());
//        Vector b = new Vector(io.nextDouble(), io.nextDouble(), io.nextDouble());
//
//        System.out.println("Длина а = " + a.length());
//        System.out.println("Длина b = " + b.length());
//
//        System.out.println("(a, b) = " + a.scalarProduct(b));
//
//        System.out.println("a x b = " + a.crossProduct(b).toString());
//
//        System.out.println("cos угла между a и b = " + a.cos(b));
//
//        System.out.println("a + b = " + a.add(b).toString());
//
//        System.out.println("a - b = " + a.subtract(b).toString());
//
//        System.out.println("Хеш а: " + a.hashCode());
//        System.out.println("Хеш b: " + b.hashCode());
//
//        System.out.println("Результат equals: " + a.equals(b));

        ///
        System.out.println("\r\n\r\nЗадача 2: Иерархия классов компьютеров\r\n");

        Computer computers[] = new Computer[2];
        computers[0] = new Tablet("Huawei", "MatePad Pro 10.8", "HUAWEI Kirin 990 (8)", "6Gb", "128Gb");
        computers[1] = new Notebook("Lenovo", "ThinkPad L13", "Intel Core i7 10510U", "16384Mb", "ssd 512Gb", "13.3\", 1920×1080", "\"встроенная\"");
//        computers[2] = new Netbook();
//        computers[3] = new PersonalComputer();
//        computers[4] = new Nettop();
//        computers[5] = new Monoblock();
//        computers[6] = new Server();
        for (Computer computer : computers) {
            System.out.println(computer.turnOn());
            System.out.println(computer.connect());
            System.out.println(computer.turnOff() + "\r\n");
        }

    }
}
