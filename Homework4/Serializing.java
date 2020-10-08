package Homework4;


import Homework2.Vector;
import java.io.*;
import java.util.Scanner;

public class Serializing {
    private static final int NUM = 2; //кол-во векторов
    //private static final int WAIT = 2;

    public static void main(String[] args) throws InterruptedException {
        Vector vecs[] = new Vector[NUM];
        String coords[], next;

        //Считываем в текстовом виде
        try {
            Scanner io = new Scanner(new FileReader("vectors.list"));
            for (int i = 0; i < NUM; i++) {
                next = io.nextLine();
                coords = (next.substring(1, next.length() - 1).split(", "));
                vecs[i] = new Vector(Double.parseDouble(coords[0]),
                        Double.parseDouble(coords[1]), Double.parseDouble(coords[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Сериализуем
        try {
            FileOutputStream fos = new FileOutputStream("vectors.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < NUM; i++) {
                oos.writeObject(vecs[i]);
            }
            oos.close();
            //Thread.sleep(WAIT * 1000);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Десериализуем
        try {
            FileInputStream fis = new FileInputStream("vectors.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            for (int i = 0; i < NUM; i++) {
                vecs[i] = (Vector)ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Записываем в текстовом виде
        try {
            FileWriter wr = new FileWriter("vectors.list");
            for (int i = 0; i < NUM; i++) {
                wr.write(vecs[i].toString());
            }
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
