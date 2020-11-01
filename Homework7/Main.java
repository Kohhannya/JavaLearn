package Homework7;

public class Main {

    public static void main(String[] args) {

        RunnableThread runnableThread = new RunnableThread();
        runnableThread.run();

        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.start();

    }
}

