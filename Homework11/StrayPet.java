package Homework11;

import java.util.Scanner;

@FunctionalInterface
interface Taming {
    HomePet tame(StrayPet strayPet, String newOwnerName);
}

public class StrayPet {
    String name;
    int age;

    public StrayPet(String[] mas) {
        this.name = mas[0];
        this.age = Integer.parseInt(mas[1]);
    }

    @Override
    public String toString() {
        return "Бездомный питомец{" +
                "имя='" + name + '\'' +
                ", возраст=" + age +
                '}';
    }

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        StrayPet musha = new StrayPet(io.nextLine().split(" ")); //Муша 8
        StrayPet lord = new StrayPet(io.nextLine().split(" ")); //Лорд 11

        System.out.println(musha);
        System.out.println(lord);
        System.out.println();

        Taming taming = (strayPet, ownerName) -> new HomePet(strayPet.name, strayPet.age, ownerName);

        HomePet homeMusha = taming.tame(musha, "Екатерина");
        HomePet homeLord = taming.tame(lord, "Алехандро");

        System.out.println(homeMusha);
        System.out.println(homeLord);
    }
}
