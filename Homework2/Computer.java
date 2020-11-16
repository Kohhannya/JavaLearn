package Homework2;

import Homework9.Visitor;

import java.util.ArrayList;

public interface Computer {
    String turnOn();

    String turnOff();

    String connect();

    String accept(Visitor v);
}

abstract class ComputerImpl implements Computer {

    private String maker;
    private String model;

    private ArrayList<Component> components = new ArrayList<>();

    public ComputerImpl(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        this.maker = maker;
        this.model = model;
        components.add(cpu);
        components.add(ram);
        components.add(hdd);
    }

    public String getMarker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public Component getCPU() {
        return components.get(0);
    }

    public Component getRAM() {
        return components.get(1);
    }

    public Component getHDD() {
        return components.get(2);
    }

    //так мы избавляемся от дублирующего кода
    //в дальнейшем, все что нам нужно - переопределить метод toString
    public String turnOn() {
        return getClass().getSimpleName() + " " + toString() + "has turned on";
    }

    public String turnOff() {
        return getClass().getSimpleName() + " " + toString() + "has turned off";
    }

    public String connect() {
        return getClass().getSimpleName() + " " + toString() + "has connected to internet";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n");
        for (Component component : components) {
            sb.append(component.printComponent() + "\r\n");
        }
        return sb.toString();
    }
}

abstract class PortableComputer extends ComputerImpl { //Шаблон портативного компьютера

    public PortableComputer(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(Portable Computer):\r\n");
        for (Component component : getComponents()) {
            sb.append(component.printComponent() + "\r\n");
        }
        return sb.toString();
    }
}

abstract class DesktopComputer extends ComputerImpl { //Шаблон настольного компьютера

    public DesktopComputer(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(Desktop Computer):\r\n");
        for (Component component : getComponents()) {
            sb.append(component.printComponent() + "\r\n");
        }
        return sb.toString();
    }
}


//"производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + " и жестким диском " + HDD + " "