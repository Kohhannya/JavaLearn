package Homework9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    private static final int L = 256;
    public static void main(String[] args) {
        FileInputStream inputStream;
        int bytes[] = new int[L], min = Integer.MAX_VALUE / 2;
        try {

            inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            while (inputStream.available() > 0) {
                bytes[inputStream.read()]++;
            }
            for (int i = 0; i < L; i++) {
                if (bytes[i] > 0)
                    min = Math.min(min, bytes[i]);
            }
            for (int i = 0; i < L; i++) {
                if (min == bytes[i])
                    System.out.print(i + " ");
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
