package Homework8;

import java.util.concurrent.Semaphore;

public final class Singleton {
    private static Semaphore SEMAPHORE = null;
    private static Singleton instance;
    String value;

    private Singleton(String value) {
        // Этот код эмулирует медленную инициализацию
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    static Singleton getInstance(String value) {
        try {
            SEMAPHORE.acquire(); //в каждый момент только 1 поток может пытаться получить синглетон
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        if (instance == null) {
            instance = new Singleton(value);
        }
        SEMAPHORE.release();
        return instance;
    }

    public static void main(String[] args) {
        SEMAPHORE = new Semaphore(1, true); //пускаем потоки по принципу FIFO
        //код программы
    }
}