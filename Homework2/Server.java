package Homework2;

public class Server extends ComputerImpl {

    public Server(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
        voltage = 380;
    }
}
