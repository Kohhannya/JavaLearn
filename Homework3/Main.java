package Homework3;

import Homework2.Vector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {

        Class clazz = Vector.class;
        Vector v1 = null, v2 = null;
        try {
            Class[] params = {double.class, double.class, double.class};
            v1 = (Vector) clazz.getConstructor(params).newInstance(1, 0, 0);
            v2 = (Vector) clazz.getConstructor(params).newInstance(0, 1, 0); //Здесь менять приватные координаты
        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Method equals = clazz.getMethod("equals", Object.class);
        Method hashcode = clazz.getMethod("hashCode");
        Method length = clazz.getMethod("length");
        Method scal = clazz.getMethod("scalarProduct", Vector.class);
        Method vect = clazz.getMethod("crossProduct", Vector.class);
        Method cos = clazz.getMethod("cos", Vector.class);
        Method add = clazz.getMethod("add", Vector.class);
        Method sub = clazz.getMethod("subtract", Vector.class);

        System.out.println("Сравнение: " + equals.invoke(v1, v2));

        System.out.println("\r\nХеши:\r\n" + hashcode.invoke(v1));
        System.out.println(hashcode.invoke(v2));

        System.out.println("\r\nДлины:\r\n" + length.invoke(v1));
        System.out.println(length.invoke(v2));

        System.out.println("\r\nСкалярное: " + scal.invoke(v1, v2));
        System.out.println("Векторное: " + vect.invoke(v1, v2));
        System.out.println("Косинус: " + cos.invoke(v1, v2));

        System.out.println("\r\nСумма: " + add.invoke(v1, v2));
        System.out.println("Разность: " + sub.invoke(v1, v2));
    }
}