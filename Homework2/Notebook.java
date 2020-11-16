package Homework2;

import Homework9.Visitor;

public class Notebook extends PortableComputer {

    private Display display;
    private Keyboard keyboard;

    public Notebook(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
        this.keyboard = keyboard;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitNotebook(this);
    }
}
