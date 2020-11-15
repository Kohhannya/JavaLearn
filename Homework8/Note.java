package Homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Note {

    public final List<String> notes = new ArrayList<String>();
    private ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

    public Note() { }

    public void addNote(int index, String note) {
        System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
        LOCK.writeLock().lock();
        try {
            notes.add(index, note);
        } finally {
            LOCK.writeLock().unlock();
        }
        System.out.println("Уже добавлена заметка [" + note + "]");

    }

    public void removeNote(int index) {
        System.out.println("Сейчас будет удалена заметка с позиции " + index);
        String note;
        LOCK.writeLock().lock();
        try {
            note = notes.remove(index);
        } finally {
            LOCK.writeLock().unlock();
        }
        System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
    }

    public void readNote(int index) {
        System.out.println("Сейчас будет прочтена заметка с позиции " + index);
        String note;
        LOCK.readLock().lock();
        try {
            note = notes.get(index);
        } finally {
            LOCK.readLock().unlock();
        }
        System.out.println("Прочтена заметка [" + note + "] с позиции " + index);

    }
}