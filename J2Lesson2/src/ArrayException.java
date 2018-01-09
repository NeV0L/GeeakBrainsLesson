import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Write a description of class J2Lesson2 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 26, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class ArrayException {
    // Файл для чтения
    private static final String FILE_NAME = "array.txt";
    // Размер матрицы
    private static final int ARRAY_LENGTH = 4;
    // Сумма всех элементов матрицы
    private static int sumNum = 0;

    public static void main(String[] args) {
        // записываем файл со случайными значениями
        writeFile();

        try {
            sumArray(fillArray(readFile().toString()));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Рассчитываем сумму значений матрицы
     */
    public static void sumArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumNum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException(
                            "Значение не соответствует формату в колонке/строке: " + (i + 1) + "/" + (j + 1));
                }
            }
        }

        System.out.printf("Результат расчета: %d \n", sumNum);
    }

    public static String[][] fillArray(String str) {
        String[] lines = str.split("\n");
        String[][] array = new String[lines.length][];

        // Проверяем количество строк в матрице
        if (lines.length != ARRAY_LENGTH) {
            throw new ArrayIndexOutOfBoundsException("Массив не соответствует количеству строк");
        }

        for (int i = 0; i < lines.length; i++) {
            array[i] = lines[i].split(" ");
            // Проверяем количество колонок
            if (array[i].length != ARRAY_LENGTH) {
                throw new ArrayIndexOutOfBoundsException("Массив не соответствует количеству колонок в " + (i + 1) + " строке");
            }
        }

        return array;
    }

    /**
     * Создаем\пересоздаем файл со случайным набором значений
     */
    public static void writeFile() {
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(fillRandomIntArray().toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Читаем файл
     * @return StringBuffer - список значений из файла
     */
    public static StringBuilder readFile() {
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner sc = new Scanner(new File(FILE_NAME))) {
            sc.useDelimiter("");

            while (sc.hasNext()){
                stringBuilder.append(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder;
    }

    /**
     * Заполнение строки случайными числами до 100
     * @return StringBuilder - возращает строки с числами в виде матрицы
     */
    public static StringBuilder fillRandomIntArray() {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        int tmpNum = 0;

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            for (int j = 0; j < ARRAY_LENGTH; j++) {
                tmpNum = random.nextInt(100);
                str.append(tmpNum + " ");
            }

            str.append("\n");
        }

        System.out.println(str);

        return str;
    }
}
