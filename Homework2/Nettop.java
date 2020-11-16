package Homework2;

import Homework9.Visitor;

public class Nettop extends DesktopComputer {

    public Nettop(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    @Override
    public String accept(Visitor v) {
        return v.visitNettop(this);
    }
}
