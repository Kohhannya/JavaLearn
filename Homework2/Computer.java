package Homework2;

import java.util.ArrayList;

public interface Computer {
    String turnOn();

    String turnOff();

    String connect();
}

abstract class ComputerImpl implements Computer {

    String maker;
    String model;

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
        for (Component component : components) {
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
        for (Component component : components) {
            sb.append(component.printComponent() + "\r\n");
        }
        return sb.toString();
    }
}



///
class Tablet extends PortableComputer {

    public Tablet(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }
}

class Notebook extends PortableComputer {

    Display display;
    Keyboard keyboard;

    public Notebook(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
        this.keyboard = keyboard;
    }
}

class Netbook extends PortableComputer {

    Display display;
    Keyboard keyboard;

    public Netbook(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display, Keyboard keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
        this.keyboard = keyboard;
    }
}

class PersonalComputer extends DesktopComputer {

    GraphicsCard graphicsCard;

    public PersonalComputer(String maker, String model, CPU cpu, RAM ram, HDD hdd, GraphicsCard graphicsCard) {
        super(maker, model, cpu, ram, hdd);
        this.graphicsCard = graphicsCard;
    }
}

class Nettop extends DesktopComputer {

    public Nettop(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }
}

class Monoblock extends DesktopComputer {

    Display display;

    public Monoblock(String maker, String model, CPU cpu, RAM ram, HDD hdd, Display display) {
        super(maker, model, cpu, ram, hdd);
        this.display = display;
    }
}

class Server extends ComputerImpl {

    public Server(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }
}

//"производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + " и жестким диском " + HDD + " "