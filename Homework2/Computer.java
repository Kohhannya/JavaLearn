package Homework2;

import java.security.Signature;

public interface Computer {
    String turnOn();
    String turnOff();
    String connect();
}

abstract class ComputerImpl implements Computer {

    String maker;
    String model;

    String CPU;
    String RAM;
    String HDD;

    public ComputerImpl(String maker, String model, String cpu, String ram, String hdd) {
        this.maker = maker;
        this.model = model;
        CPU = cpu;
        RAM = ram;
        HDD = hdd;
    }

    //так мы избавляемся от дублирующего кода
    //в дальнейшем, все что нам нужно - переопределить метод toString
    public String turnOn() {
        return getClass().getSimpleName()+" "+toString() + "has turned on";
    }

    public String turnOff() {
        return getClass().getSimpleName()+" "+toString() + "has turned off";
    }

    public String connect() {
        return getClass().getSimpleName()+" "+toString() + "has connected to internet";
    }
}

abstract class PortableComputer extends ComputerImpl { //Шаблон портативного компьютера

    public PortableComputer(String maker, String model, String cpu, String ram, String hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    public String toString() {
        return "(Portable computer) производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + " и жестким диском " + HDD + " ";
    }
}

abstract class DesktopComputer extends ComputerImpl { //Шаблон настольного компьютера

    public DesktopComputer(String maker, String model, String cpu, String ram, String hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    public String toString() {
        return "(Desktop computer) производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + " и жестким диском " + HDD + " ";
    }
}

///
class Tablet extends PortableComputer {

    public Tablet(String maker, String model, String cpu, String ram, String hdd) {
        super(maker, model, cpu, ram, hdd);
    }
}

class Notebook extends PortableComputer {

    Display display;
    Keyboard keyboard;

    public Notebook(String maker, String model, String cpu, String ram, String hdd, String display, String keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = new Display(display);
        this.keyboard = new Keyboard(keyboard);
    }

    public String toString() {
        return "(Desktop computer) производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + ", жестким диском " + HDD + ", дисплеем " + display.name + " и клавиатурой " + keyboard.name + " ";
    }
}

class Netbook extends PortableComputer {

    Display display;
    Keyboard keyboard;

    public Netbook(String maker, String model, String cpu, String ram, String hdd, String display, String keyboard) {
        super(maker, model, cpu, ram, hdd);
        this.display = new Display(display);
        this.keyboard = new Keyboard(keyboard);
    }

    public String toString() {
        return "(PortableComputer) производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + ", жестким диском " + HDD + ", дисплеем " + display.name + " и клавиатурой " + keyboard.name + " ";
    }
}

class PersonalComputer extends DesktopComputer {

    String graphicsCard;

    public PersonalComputer(String maker, String model, String cpu, String ram, String hdd, String graphicsCard) {
        super(maker, model, cpu, ram, hdd);
        this.graphicsCard = graphicsCard;
    }
}

class Nettop extends DesktopComputer {

    public Nettop(String maker, String model, String cpu, String ram, String hdd) {
        super(maker, model, cpu, ram, hdd);
    }
}

class Monoblock extends DesktopComputer {

    Display display;

    public Monoblock(String maker, String model, String cpu, String ram, String hdd, String display) {
        super(maker, model, cpu, ram, hdd);
        this.display = new Display(display);
    }

    public String toString() {
        return "(Desktop computer) производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + ", жестким диском " + HDD + "и дисплеем " + display.name + " ";
    }
}

class Server extends ComputerImpl {

    public Server(String maker, String model, String cpu, String ram, String hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

///
class Display {
    String name;

    public Display(String nameOfDisplay) {
        name = nameOfDisplay;
    }
}

class Keyboard {
    String name;

    public Keyboard(String nameOfKeyboard) {
        name = nameOfKeyboard;
    }
}
//"производителя " + maker + ", модели " + model + ", процессором " + CPU + ", оперативной памятью " + RAM + " и жестким диском " + HDD + " "