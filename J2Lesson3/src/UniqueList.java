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

    public static void main(String[] args) {
        // выводим только уникальные слова
        checkDuplicate(readFile(), false);
        // считаем сколько раз встречается каждое слово
        checkDuplicate(readFile(), true);
    }

    /**
     * Считаем сколько раз встречается каждое слово.
     * @param stringArrayList - список слов для проверки
     * @param isCount - флаг, необходимо ли выводить количество повторяющихся слов
     */
    public static void checkDuplicate(ArrayList<String> stringArrayList, boolean isCount) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        Integer count;
        for (String str: stringArrayList) {
            count = hashMap.get(str);
            hashMap.put(str, count == null ? 1 : count + 1);
        }

        if (isCount) {
            System.out.println(hashMap);
        } else {
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() == (Integer) 1 ) {
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
