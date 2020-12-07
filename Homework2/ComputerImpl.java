package Homework2;

import Homework3.ComputerConnectionError;
import Homework3.ComputerTurnOffException;
import Homework3.ComputerTurnOnException;

import java.util.ArrayList;

abstract public class ComputerImpl implements Computer, Comparable<ComputerImpl> {

    String maker;
    String model;
    int voltage;
    boolean isOn = false;

    ArrayList<Component> components = new ArrayList<>();

    public ComputerImpl(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        this.maker = maker;
        this.model = model;
        components.add(cpu);
        components.add(ram);
        components.add(hdd);
    }

    //так мы избавляемся от дублирующего кода
    //в дальнейшем, все что нам нужно - переопределить метод toString
    public String turnOn(int v) throws ComputerTurnOnException {
        if (v < voltage)
            throw new ComputerTurnOnException(getClass().getSimpleName() + " can't be turn on " +
                    "due to high voltage");
        else {
            isOn = true;
            return getClass().getSimpleName() + " " + toString() + "has turned on";
        }
    }

    public String turnOff() throws ComputerTurnOffException {
        if (!isOn)
            throw new ComputerTurnOffException("The computer hasn't been turn on");
        else {
            isOn = false;
            return getClass().getSimpleName() + " " + toString() + "has turned off";
        }
    }

    public String connect(boolean wifi) throws ComputerConnectionError {
        if (!isOn)
            throw new ComputerConnectionError("The computer hasn't been turn on");
        else if (!wifi)
            throw new ComputerConnectionError("There is no nets around to connect with");
        else
            return getClass().getSimpleName() + " " + toString() + "has connected to internet";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("\r\n");
        sb.append(getClass().getSimpleName() + ":\r\n");
        sb.append("Maker: " + maker + "\r\n");
        sb.append("Model: " + model + "\r\n");
        for (Component component : components) {
            sb.append(component.printComponent() + "\r\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(ComputerImpl o) {
        if (!maker.equals(o.maker))
            return model.compareTo(o.model);
        return maker.compareTo(o.maker);
    }
}
