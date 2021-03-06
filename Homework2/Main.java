package Homework2;

import Homework3.ComputerTurnOffException;
import Homework3.ComputerTurnOnException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задача 2: Иерархия классов компьютеров\r\n");

        Computer computers[] = new Computer[3];

        CPU cpus[] = new CPU[3];
        cpus[0] = new CPU("Intel Core i7 10510U", 4, "1.8 GHz");
        cpus[1] = new CPU("Intel Core i5 9400F", 6, "2.9 GHz");
        cpus[2] = new CPU("Intel Xeon X5675 12M Cache", 6, "3.06 GHz");

        RAM rams[] = new RAM[3];
        rams[0] = new RAM("16384 Mb", "DDR4", "2666 МHz");
        rams[1] = new RAM("8192 Мb", "DIMM, DDR4", "2133 MHz");
        rams[2] = new RAM("4096 Mb", "DDR3", "1600 МГц");

        HDD hdds[] = new HDD[3];
        hdds[0] = new HDD("ssd", "512 Gb");
        hdds[1] = new HDD("ssd", "512 Gb");
        hdds[2] = new HDD("ssd", "256 Gb");

        Display noteDisplay = new Display("13.3\"", "1920×1080", true, "IPS");
        Keyboard noteKeyboard = new Keyboard("black", true, true);
        GraphicsCard pkGraghicsCard = new GraphicsCard("GDDR5", "4096 Mb", "1485 MHz");

        computers[0] = new Notebook("Lenovo", "ThinkPad L13", cpus[0], rams[0], hdds[0], noteDisplay, noteKeyboard); //пример портативного
        computers[1] = new PersonalComputer("ACER", "Aspire TC-886", cpus[1], rams[1], hdds[1], pkGraghicsCard); //пример настольного
        computers[2] = new Server("IBM", "System x3650 M3", cpus[2], rams[2], hdds[2]); //вне типов

        for (Computer computer : computers) {
            try {
                System.out.println(computer.turnOn(220) + "\r\n"); //Принимает кол-во вольт
            } catch (ComputerTurnOnException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println(computer.connect(true) + "\r\n"); /* Типо connectionStatus. Принимает переменную
                                                                                 наличия wi-fi поблизости */
            try {
                System.out.println(computer.turnOff() + "\r\n");
            } catch (ComputerTurnOffException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

//"Huawei", "MatePad Pro 10.8", "HUAWEI Kirin 990 (8)", "6Gb", "128Gb"
//"Lenovo", "ThinkPad L13", "Intel Core i7 10510U", "16384 Мб, DDR4, 2666 МГц", "ssd 512Gb", "13.3\", 1920×1080", "\"встроенная\""