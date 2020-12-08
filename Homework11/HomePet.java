package Homework11;

public class HomePet {
    String name, ownerName;
    int age;

    public HomePet(String name, int age, String ownerName) {
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Домашний питомец{" +
                "имя='" + name + '\'' +
                ", возраст=" + age +
                ", имя хозяина='" + ownerName + '\'' +
                '}';
    }
}