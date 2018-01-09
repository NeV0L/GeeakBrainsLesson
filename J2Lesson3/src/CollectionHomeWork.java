import lists.*;

import static lists.UniqueList.readFile;

/**
 * Write a description of class CollectionHomeWork here.
 *
 * @author Volsky Nikita
 * @version dated 06.01.18
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит
 * массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
 *
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с
 * помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
 * может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class CollectionHomeWork {
    public static void main(String[] args) {
        // 1 задание
        System.out.println("Задание 1:");
        // выводим только уникальные слова
        UniqueList.checkDuplicate(readFile(), false);
        // считаем сколько раз встречается каждое слово
        UniqueList.checkDuplicate(readFile(), true);
        // 2 задание
        System.out.println("\nЗадание 2:");
        TelephoneList.add("Vasya", "8-916-456-22-45");
        TelephoneList.add("Vasya", "8-916-451-11-45");
        System.out.println(TelephoneList.get("Vasya"));

    }
}
