package Homework8;

public class Main {
    static Note NOTE = new Note();
    private static final int C = 4;

    public static void main(String[] args) {

        for (int i = 0; i < C + 3; i++) {
            //NOTE.addNote(i, "что-то #" + i*i);
        }
        System.out.println("");

        //MyThread th1 = new MyWriteThread(NOTE, C);
        //MyThread th2 = new MyDeleteThread(NOTE, C);
    }
}

abstract class MyThread implements Runnable {
    Thread thread;
    Note note;
    static int C;

    public MyThread(Note note, int c) {
        this.note = note;
        C = c;
    }
}

class MyWriteThread extends MyThread {

    public MyWriteThread(Note note, int c) {
        super(note, c);
        thread = new Thread(this, "Runnable поток записи");
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < C; i++) {
            note.addNote(i, "заметка " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class MyDeleteThread extends MyThread {

    public MyDeleteThread(Note note, int c) {
        super(note, c);
        thread = new Thread(this, "Runnable поток удаления");
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < C; i++) {
            note.removeNote(i);
        }
    }
}
