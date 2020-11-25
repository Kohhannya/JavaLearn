package Homework10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnglishLetters {
    public static void main(String[] args) {
        FileInputStream inputStream;
        int counter = 0, next;
        try {

            inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
            while (inputStream.available() > 0) {
                next = inputStream.read();
                if (65 <= next && next <= 90 || 97 <= next && next <= 122)
                    counter++;
            }
            System.out.println(counter);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//C:\\Users\\Люба\\IdeaProjects\\Homeworks\\src\\Homework10\\input.txt