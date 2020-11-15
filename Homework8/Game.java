package Homework8;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Player 1", 4);
        protected Gamer gamer2 = new Gamer("Player 2", 4);
        protected Gamer gamer3 = new Gamer("Player 3", 4);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            int c = 1000 / rating;
            if (!isInterrupted()) {
                for (String s : OnlineGame.steps) {
                    if (!isInterrupted()) {
                        try {
                            Thread.sleep(c);
                        } catch (InterruptedException e) {
                            break;
                        }

                        if (!isInterrupted()) System.out.println(this.getName() + ":" + s);
                    }
                }
            }

            if (!isInterrupted() && !OnlineGame.isWinnerFound) {
                OnlineGame.isWinnerFound = true;
                System.out.println(this.getName() + ":" + "победитель!");
            } else {
                System.out.println(this.getName() + ":" + "проиграл");
            }
        }
    }
}