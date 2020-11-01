package Homework6;

import javax.xml.bind.Element;
import java.util.*;

public class Main {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Петров", "Данил");
        map.put("Капустин", "Дмитрий");
        map.put("Алексеев", "Даниил");
        map.put("Семечкин", "Илья");
        map.put("Шушина", "Александра");
        map.put("Шемякин", "Александр");
        map.put("Старичкова", "Анна");
        map.put("Иванов", "Даниил");
        map.put("Лисова", "Вероника");
        map.put("Кудрявцев", "Дмитрий");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashSet<String> names = new HashSet<String>(), dubles = new HashSet<String>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!names.add(entry.getValue()))
                dubles.add(entry.getValue());
        }

        for (String name : dubles) {
            removeItemFromMapByValue(map, name);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            if (entry.getValue().equals(value)) {
                map.remove(entry.getKey(), entry.getValue());
                entries = map.entrySet().iterator();
            }
        }
    } //фу, я бы вообще такой метод не использовала...

    public static void printMap(HashMap<String,String> map){
        for (HashMap.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();

        printMap(map);
        removeTheFirstNameDuplicates(map);

        printMap(map);
    }
}
