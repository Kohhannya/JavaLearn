package Homework9;

import java.io.*;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        FileInputStream inputStream;
        FileOutputStream out1, out2;

        int l;
        try {

            out1 = new FileOutputStream("out1.txt");
            out2 = new FileOutputStream("out2.txt");

            ArrayList<Integer> list = new ArrayList<Integer>();
            inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            while (inputStream.available() > 0) {
                list.add(inputStream.read());
            }
            l = (list.size() + 1) / 2;
            for (int i = 0; i < list.size(); i++) {
                if (i < l) out1.write(list.get(i));
                else out2.write(list.get(i));
            }
            inputStream.close();
            out1.close();
            out2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
