package Homework11;

import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ternary<T, R> implements Function<T, R> {
    Predicate<T> condition;
    Function<T, R> ifTrue, ifFalse;

    public Ternary(Predicate<T> condition, Function<T, R> ifTrue, Function<T, R> ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public R apply(T t) {
        if (condition.test(t))
            return ifTrue.apply(t);
        else
            return ifFalse.apply(t);
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        Predicate<Integer> isPositive = x -> x > 0;
        Function<Integer, String> ifPositive = x -> "Число " + x + " положительное.";
        Function<Integer, String> ifNotPositive = x -> "Число " + x + " не является положительным!";

        Ternary<Integer, String> ternary = new Ternary<>(isPositive, ifPositive, ifNotPositive);

        System.out.println(ternary.apply(io.nextInt()));
        System.out.println(ternary.apply(io.nextInt()));
        System.out.println(ternary.apply(io.nextInt()));
    }
}
