package Homework2;

///
public class Tablet extends PortableComputer {

    public Tablet(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
        voltage = 10;
    }
}
