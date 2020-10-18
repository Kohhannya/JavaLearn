package Homework5;

import java.util.ArrayList;
import java.util.Scanner;

// Задача 2
public class WorkList {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        //ArrayList<Integer> everything = new ArrayList<>();
        ArrayList<Integer> div3 = new ArrayList<>(), div2 = new ArrayList<>(), others = new ArrayList<>();

        int next;
        for (int i = 0; i < 20; i++) {
            next = io.nextInt();

            //everything.add(next);
            if (next % 3 == 0) div3.add(next);
            if (next % 2 == 0) div2.add(next);
            if (next % 2 != 0 && next % 3 != 0) others.add(next);
        }

        //System.out.println("Делятся на 3:");
        printList(div3);
        //System.out.println("Делятся на 2:");
        printList(div2);
        //System.out.println("Остальные:");
        printList(others);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int e : list) {
            System.out.println(e);
        }
        System.out.println("");
    }
}
