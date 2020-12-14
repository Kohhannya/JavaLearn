package Homework12;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import Homework2.Vector;

public class Methods {

    // Task №1
    public static IntStream fibonacciStream(int f1, int f2, int sum) { //возможность задать первые элементы (sum >= f1)
        ArrayList<Integer> list = new ArrayList<>();
        /*  Условию не противоречит,но выглядит, как костыль))
            Может, позже попробую без списков реализовать...   */

        int currentSum = f1 + f2, nextElement = f2;
        list.add(f1);

        while (currentSum <= sum) {
            list.add(nextElement);
            nextElement += list.get(list.size() - 2);
            currentSum += nextElement;
        }

        return list.stream().mapToInt(n -> n);
    }

    // Task №2
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order)
                .collect(Collectors.toList());
        if (list.size() != 0)
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        else
            minMaxConsumer.accept(null, null);
    }

    // Task №3
    public static <T> void findMostFrequent(List<? extends T> list) {
        Set<T> set = new HashSet<>(list);
        Map<T, Integer> map = set.stream()
                .collect(Collectors.toMap(s -> s, s -> 0));

        list.stream().forEach(s -> map.put(s, map.get(s) + 1));
        Map.Entry ans = map.entrySet().stream()
                .max(Map.Entry.comparingByValue(Integer::compareTo)).orElse(null);
        System.out.println("Наиболее встречающийся: " + ans.getKey());
    }

    // Task №4
    public static Map<Vector, Double> vectorsLengths(Collection<Vector> vectors) {
        //Set<Vector> set = new HashSet<Vector>(vectors);
        Map<Vector, Double> map = vectors.stream()
                .collect(Collectors.toMap(v -> v, Vector::length));
        return map;
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        //1
        IntStream stream1 = fibonacciStream(1, 1, 10); //io.nextInt()
        stream1.forEach(System.out::println);

        //2
        Stream<Integer> stream2 = Stream.of(1, 2, 4, 33);
        findMinMax(stream2, Integer::compareTo, new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println("Минимальный элемент: " + integer + ", максимальный: " + integer2);
            }
        });

        //3
        List<Integer> list3 = Arrays.asList(1, 2, 2, 33, 1, 5, 2);
        findMostFrequent(list3);

        //4
        List<Vector> list4 = Arrays.asList(
                new Vector(1, 0, 0),
                new Vector(3, 4, 0),
                new Vector(0, 1, 1));
        vectorsLengths(list4).entrySet().stream().forEach(System.out::println);
    }
}
