package Homework2;

import Homework9.Visitor;

public class Tablet extends PortableComputer {

    public Tablet(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    @Override
    public String accept(Visitor v) {
        return v.visitTablet(this);
    }
}
