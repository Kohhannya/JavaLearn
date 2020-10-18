package Homework5;

import java.util.HashSet;
import java.util.Set;

// Задача 3
public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            set1.add(i); // 0, 1, 2
        }

        for (int i = 0; i < 6; i += 2) {
            set2.add(i); // 0, 2, 4
        }

        /*
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        set1.add("32");
        set1.add(1);
        set1.add("435");

        set2.add("32");
        set2.add(2);
        set2.add("325");
        */

        Set answer = symmetricDifference(set1, set2);
        for (Object el : answer) {
            System.out.print(el + " ");
        }
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> ans = new HashSet<>();

        for (T el : set1) {
            if (!set2.contains(el)) ans.add(el);
        }
        for (T el : set2) {
            if (!set1.contains(el)) ans.add(el);
        }

        return ans;
    }
}
