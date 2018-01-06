package lists;

import java.util.*;
import java.util.HashMap;

/**
 * Write a description of class TelefoneList here.
 *
 * @author Volsky Nikita
 * @version dated 06.01.18
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

public class TelephoneList {
    // Список в котором хранятся телефоны и фамилии
    private static HashMap<String, String> telDir = new HashMap<>();

    /**
     * Метод для добавления новых записей в телефонный справочник
     */
    public static void add(String lastName, String telephone) {
        telDir.put(telephone, lastName);
    }

    /**
     * Метод возвращает список телефонных номеров по имени
     * @param name - имя, по которому необходимо произвести поиск номеров
     * @return List<String> - возвращает список номеров
     */
    public static List<String> get(String name) {
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, String> entry : telDir.entrySet())
            if (name.equals(entry.getValue()))
                list.add(entry.getKey());

        return list;
    }

}

