package Homework11;

import Homework2.*;

import java.util.Set;
import java.util.TreeSet;

public class ComputerSort {
    public static void main(String[] args) {
        Computer[] array = Main.testInit();

        System.out.println("До сортировки:");
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }

        Set<ComputerImpl> tree = new TreeSet<ComputerImpl>();
        for (int i = 0; i < 3; i++) {
            tree.add((ComputerImpl)array[i]);
        }

        System.out.println("\nПосле сортировки:");
        for (ComputerImpl computer : tree) {
            System.out.println(computer);
        }
    }
}
