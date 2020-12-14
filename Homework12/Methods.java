package Homework12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Methods {

    // Task №1
    public static IntStream fibonacciStream(int f1, int f2, int sum) { //возможность задать первые элементы (sum >= f1)
        ArrayList<Integer> list = new ArrayList<>();
        /*  Условию не противоречит,но костыль))
            Позже попробую без списков реализовать...   */

        int currentSum = f1 + f2, nextElement = f2;
        list.add(f1);

        while (currentSum <= sum) {
            list.add(nextElement);
            nextElement += list.get(list.size() - 2);
            currentSum += nextElement;
        }

        return list.stream().mapToInt(n -> n);
    }

    //Task №2
    

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        fibonacciStream(1, 1, io.nextInt()).forEach(System.out::println);
    }
}
