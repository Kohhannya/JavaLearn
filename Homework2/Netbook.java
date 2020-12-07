package Homework2;

public class Netbook extends PortableComputer {

    Display display;
    Keyboard keyboard;

    public Netbook(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
        this.keyboard = keyboard;
        voltage = 5;
    }
}
