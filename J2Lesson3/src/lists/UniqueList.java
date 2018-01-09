package lists;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Write a description of class J2Lesson3 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 30, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

public class UniqueList {
    // Файл для чтения
    private static final String FILE_NAME = "ListWords.txt";

    /**
     * Считаем сколько раз встречается каждое слово.
     * @param stringArrayList - список слов для проверки
     * @param isCount - флаг, необходимо ли выводить количество повторяющихся слов
     */
    public static void checkDuplicate(ArrayList<String> stringArrayList, boolean isCount) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String str: stringArrayList) {
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }

        if (isCount) {
            System.out.println(hashMap);
        } else {
            for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
                if (entry.getValue().equals(1)) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }

    /**
     * Читаем файл
     * @return ArrayList<String> - список значений из файла
     */
    public static ArrayList<String> readFile() {
        ArrayList<String> stringBuilder = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(FILE_NAME))) {
            sc.useDelimiter(",");

            while (sc.hasNext()){
                stringBuilder.add(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder;
    }
}
