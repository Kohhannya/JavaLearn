package Homework2;

import Homework9.Visitor;

public class Monoblock extends DesktopComputer {

    private Display display;

    public Monoblock(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
    }

    public Display getDisplay() {
        return display;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitMonoblock(this);
    }
}
