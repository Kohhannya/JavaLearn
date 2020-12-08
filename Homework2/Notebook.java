package Homework2;

public class Notebook extends PortableComputer {

    Display display;
    Keyboard keyboard;

    public Notebook(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
        this.keyboard = keyboard;
        voltage = 20;
    }
}
