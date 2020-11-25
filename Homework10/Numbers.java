package Homework10;

import java.io.*;
import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine(), name2 = scanner.nextLine();

        findNumbers(name1, name2);
    }

    public static void findNumbers(String input, String output) {
        BufferedReader breader;
        FileWriter writer;
        String s[];
        boolean num;

        try {
            breader = new BufferedReader(new FileReader(input));
            writer = new FileWriter(output);

            s = breader.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                num = true;
                for (int j = 0; j < s[i].length(); j++) {
                    if (!(48 <= s[i].charAt(j) && s[i].charAt(j) <= 57)) {
                        num = false;
                        break;
                    }
                }
                if (num) writer.write(s[i] + " ");
            }
            breader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//C:\\Users\\Люба\\IdeaProjects\\Homeworks\\src\\Homework10\\input.txt
//C:\\Users\\Люба\\IdeaProjects\\Homeworks\\src\\Homework10\\output.txt