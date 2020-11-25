package Homework9;

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        FileInputStream inputStream;
        int max = -1;
        try {

            inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            while (inputStream.available() > 0) {
                max = Math.max(max, inputStream.read());
            }
            System.out.println(max);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//C:\\Users\\Люба\\IdeaProjects\\Homeworks\\src\\Homework9\\input.txt
