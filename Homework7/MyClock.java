package Homework7;

public class MyClock extends Thread {

    public static void main(String[] args) throws InterruptedException {
        MyClock clock = new MyClock();
        clock.start();

        Thread.sleep(5000); // 5 секунд
        clock.interrupt();
    }

    public void run() {
        Thread current = Thread.currentThread();
        boolean tik = true;

        while (!current.isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Работа потока была прервана");
                break;
            }
            System.out.println(tik ? "Tik" : "Tak");
            tik ^= true;
        }
    }
}
