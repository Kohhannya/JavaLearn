package Homework2;

import Homework9.Visitor;

public class Server extends ComputerImpl {

    public Server(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    @Override
    public String accept(Visitor v) {
        return v.visitServer(this);
    }
}
