package Homework2;

import Homework9.Visitor;

public class Netbook extends PortableComputer {

    private Keyboard keyboard;

    public Netbook(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard) {
        super(maker, model, cpu, ram, hdd, display);
        this.keyboard = keyboard;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitNetbook(this);
    }
}
