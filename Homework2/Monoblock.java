package Homework2;

public class Monoblock extends DesktopComputer {

    Display display;

    public Monoblock(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
        voltage = 220;
    }
}
