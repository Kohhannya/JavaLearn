package Homework10;

import java.io.*;
import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine(), name2 = scanner.nextLine();

        findNumbers(name1, name2);
        scanner.close();
    }

    public static void findNumbers(String input, String output) {
        Scanner reader;
        FileWriter writer;
        String s;
//        boolean num;

        try {
            reader = new Scanner(new FileReader(input));
            writer = new FileWriter(output);

            while (reader.hasNext()) {
                s = reader.next();
                try {
                    writer.write(Integer.parseInt(s) + " ");
                } catch (NumberFormatException e) {
                    continue; //Так делать не очень хорошо, но зато довольно красиво)
                }
//                num = true;
//                for (int j = 0; j < s.length(); j++) {
//                    if (!(48 <= s.charAt(j) && s.charAt(j) <= 57)) {
//                        num = false;
//                        break;
//                    }
//                }
//                if (num) writer.write(s + " ");
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//C:\\Users\\Люба\\IdeaProjects\\Homeworks\\src\\Homework10\\input.txt
//C:\\Users\\Люба\\IdeaProjects\\Homeworks\\src\\Homework10\\output.txt