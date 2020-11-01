package Homework7;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        int amount = 0, finished;
        while (amount < 1) {
            amount = calculateHorsesFinished(horses);
        }
        finished = amount;

        while (calculateHorsesFinished(horses) != horses.size()) {
            for (Horse horse : horses) {
                if (!horse.isFinished()) {
                    //System.out.println("//Уже пришло " + calculateHorsesFinished(horses) + " лошадей\r\n");
                    System.out.println("Ждём: " + horse.getName());
                    horse.join();
                    //horse.isFinished = false;
                }
//                if (!horse.isFinished()) {
//                    horse.join();
//                }
            }
        }
        System.out.println("\r\nУ нас " + finished + " победител" + (finished == 1 ? "ь!" : "я!"));
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        for (Horse horse : horses) {
            finishedCount += horse.isFinished() ? 1 : 0;
        }

        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        String number;
        for (int i = 1; i <= horseCount; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Лошадка_" + number));
        }

        for (int i = 0; i < horseCount; i++) {
            horses.get(i).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i <= 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s += "" + i;
                if (i == 1000) {
                    s = " финишировала!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }
}
