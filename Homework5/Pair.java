package Homework5;

public class Pair<T, S> {
    private T first;
    private S second;

    public static<T, S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }

    private Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public boolean equals(Pair<T, S> o) {
        String firstA = getFirst() == null ? "" : getFirst().toString(),
                firstB = o.getFirst() == null ? "" : o.getFirst().toString();
        String secondA = getSecond() == null ? "" : getSecond().toString(),
                secondB = o.getSecond() == null ? "" : o.getSecond().toString();

        return firstA.equals(firstB) && secondA.equals(secondB);
    }

    public int hashCode() {
        int a = getFirst() == null ? 0 : getFirst().hashCode() * 31,
                b = getSecond() == null ? 0 : getSecond().hashCode();
        return a + b; //не очень качественный
    }

    public String toString() {
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(null, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(i, s);
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustBeTrue + "\r\n" + mustAlsoBeTrue);
    }
}
