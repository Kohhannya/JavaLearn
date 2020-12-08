package Homework2;

public class PersonalComputer extends DesktopComputer {

    GraphicsCard graphicsCard;

    public PersonalComputer(String maker, String model, CPU cpu, RAM ram, HDD hdd, GraphicsCard graphicsCard) {
        super(maker, model, cpu, ram, hdd);
        this.graphicsCard = graphicsCard;
        voltage = 220;
    }
}
