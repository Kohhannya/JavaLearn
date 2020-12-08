package Homework2;

public class Nettop extends DesktopComputer {

    public Nettop(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
        voltage = 12;
    }
}
