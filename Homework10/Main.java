package Homework10;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        Closeable out;
        try {
            out = new FileOutputStream(new File(name));
            out = new MyFileOutputStream (out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyFileOutputStream  implements Closeable {
    private Closeable stream;

    MyFileOutputStream (Closeable stream) {
        this.stream = stream;
    }

    @Override
    public void close() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        if (scan.next().equals("Д")) {
            //System.out.println("Закрываю");
            stream.close();
        }
    }
}
