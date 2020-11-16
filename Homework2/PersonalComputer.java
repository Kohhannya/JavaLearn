package Homework2;

import Homework9.Visitor;

public class PersonalComputer extends DesktopComputer {

    private GraphicsCard graphicsCard;

    public PersonalComputer(String maker, String model, CPU cpu, RAM ram, HDD hdd, GraphicsCard graphicsCard) {
        super(maker, model, cpu, ram, hdd);
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String accept(Visitor v) {
        return v.visitPersonalComputer(this);
    }
}
