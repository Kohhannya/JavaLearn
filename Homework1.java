package Homework;

import java.util.Arrays;

public class Homework1 {

    //ВАЖНО!
    //модификаторы методов оставьте public - так нужно мне для тестов

    //посчитать факториал числа n
    //0.5б - если посчитаете в цикле
    //1б - если посчитаете рекурсией
    public static int fact(int n){
        if (n == 2) return n;
        return fact(n - 1) * n;
    }

    //вывести таблицу умножения на экран - 1б
    //подсказка - использовать двойной for
    public static void table(){
        int t = 10;
        System.out.print("  ");
        for (int i = 1; i <= t; i++) {
            if (i > 1) System.out.printf("%2d", i);
            for (int j = 1; j <= t; j++) {
                System.out.printf("%5d", i * j);
            }
            System.out.println("");
        }
    }

    //посчитать сумму цифр числа
    //можно посчитать для трехзначного - 0.5б
    //для любого числа - 1б
    //подсказка - в случае для любого числа используйте while
    public static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //определить, является ли год високосным
    //В високосном году - 366 дней, тогда как в обычном - 365.
    //Високосным годом является каждый четвёртый год, за исключением столетий, которые не кратны 400.
    //Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
    //Годы 1600 и 2000 - високосные, так как они кратны 100 и кратны 400.
    //Годы 2100, 2200 и 2300 - не високосные.
    //за правильный ответ - 0.5б
    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    //здесь вам нужно будет использовать результат прошлой задачи
    //и вывести, сколько дней в году
    //правильный ответ - 0.5б
    public static int daysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    //определить номер дня недели по строке
    //например: Понедельник - 1
    //правильный ответ - 1б
    public static String dayOfTheWeek(String n){
        String[] mas = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресение"};
        for (int i = 0; i < 7; i++) {
            if (mas[i].equals(n)) return i + 1 + "";
        }
        return "Нет такого дня недели :)";
    }

    //вывести массив на экран в виде: [1, 5, 3, 7, 10, 2, 5]
    //правильное решение - 0.5б
    public static void printArray(int[] array){
        if (array.length > 0) System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("]");
    }

    //вывести двойной массив на экран в виде:
    // [1, 5, 3, 7, 10, 2, 5]
    // [1, 5, 3, 7, 10, 2, 5]
    // ...
    //правильное решение - 0.5б
    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            printArray(array[i]);
        }
    }

    //отсортировать одномерный массив в порядке возрастания
    //если не знаете, как сортировать, то подсказка -
    //метод пузырька (один из самых простых для понимания)
    //правильный ответ - 1б
    public static int[] sort(int[] array){
//        int k;
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[i]) {
//                    k = array[i];
//                    array[i] = array[j];
//                    array[j] = k;
//                }
//            }
//        }
        Arrays.sort(array);
        return array;
    }


    //здесь можете тестировать свои решения
    public static void main(String[] args){
        System.out.println("Факториал:");
        System.out.println(fact(10));

        System.out.println("Таблица умножения:");
        table();

        System.out.println("Сумма цифр числа:");
        System.out.println(sum(123456));

        System.out.println("Дней в году:");
        System.out.println(daysInYear(2000));

        System.out.println("День недели:");
        System.out.println(dayOfTheWeek("Воскресенье"));

        int[] array1D = {500, 1,5,3,7,10,2,5};
        System.out.println("Вывод отсортированного массива:");
        printArray(sort(array1D));

        System.out.println("Вывод двумерного массива:");
        int[][] array2D = {{1,5,3,7,10,2,5}, {19,50,39,70,109,20,59}};
        printArray(array2D);
    }
}