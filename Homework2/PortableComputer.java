package Homework2;

abstract public class PortableComputer extends ComputerImpl { //Шаблон портативного компьютера

    public PortableComputer(String maker, String model, CPU cpu, RAM ram, HDD hdd) {
        super(maker, model, cpu, ram, hdd);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + " ");
        sb.append("(Portable Computer):\r\n");
        //sb.append("\r\n");
        sb.append("Maker: " + maker + "\r\n");
        sb.append("Model: " + model + "\r\n");
        for (Component component : components) {
            sb.append(component.printComponent() + "\r\n");
        }
        return sb.toString();
    }
}
