package Homework5;

import java.util.NoSuchElementException;
import java.util.Scanner;

public interface SimpleList {

    /**
     * Добавить элемент в конец списка
     */
    void add(int item);

    /**
     * удалить элемент по индексу idx, если такого индекса нет или он невалидный,
     * то бросить ошибку, если ок - вернуть удаленный элемент
     */
    int remove(int idx) throws NoSuchElementException;

    /**
     * Получить элемент с позиции idx или бросить исключение, если такого индекса нет
     */
    int get(int idx) throws NoSuchElementException;

    /**
     * Количество элементов списка
     */
    int size();
}

class MyArrayList implements SimpleList { // "0" - недопустимое значение элемента списка, так как используется в коде

    private int array[];
    private  int current_size = 0;
    private  int size;

    public MyArrayList() {
        size = 100;
        array = new int[size];
    }

    public MyArrayList(int capacity) {
        size = capacity;
        array = new int[size];
    }

    @Override
    public void add(int item) {
        if (current_size == size) {
            int[] array1 = new int[size * 2];
            for (int i = 0; i < size; i++) {
                array1[i] = array[i];
            }
            size *= 2;
            array = array1;
        }

        array[current_size] = item;
        current_size++;
    }

    @Override
    public int remove(int idx) throws NoSuchElementException {
        int rm;
        if (idx >= size || array[idx] == 0)
            throw new NoSuchElementException("В массиве нет элемента с таким индексом");
        else
            rm = array[idx];

        while (idx + 1 < size && array[idx + 1] != 0) {
            array[idx] = array[idx + 1];
            idx++;
        }
        current_size--;
        return rm;
    }

    @Override
    public int size() {
        return current_size;
    }

    @Override
    public int get(int idx) throws NoSuchElementException{
        int el;
        if (idx >= size || array[idx] == 0)
            throw new NoSuchElementException("В массиве нет элемента с таким индексом");
        else
            el = array[idx];
        return el;
    }

//    public static void main(String[] args) {
//        Scanner io = new Scanner(System.in);
//        MyArrayList list = new MyArrayList(5);
//
//        for (int i = 0; i < 10; i++) {
//            list.add(io.nextInt());
//            System.out.println(list.size + " " + list.current_size + " " + list.get(list.current_size-1));
//        }
//    }
}