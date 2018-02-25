import java.util.ArrayList;

/**
 * Write a description of class GenericHomeWork here.
 *
 * @author Volsky Nikita
 * @version dated 03.02.18
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

public class GenericHomeWork {

    public static void main(String[] args) {
        // Создаем Массивы
        ArrayGeneric<String> agStr = new ArrayGeneric<>(new String[]{"Hello", "Wait", "Bye"});
        ArrayGeneric<Integer> agInt = new ArrayGeneric<>(new Integer[]{1, 2, 3, 4, 5});
        ArrayGeneric<Double> agDoub = new ArrayGeneric<>(new Double[]{1.5, 2.1, 3.6, 4.7, 5.9});
        // 1 задание
        // Выводим значения массивов на экран
        System.out.println(agDoub.printObj());
        System.out.println(agInt.printObj());
        System.out.println(agStr.printObj());
        // меняем местами значения
        agDoub.changeIndex(2, 3);
        agInt.changeIndex(1,3);
        agStr.changeIndex(2,1);
        // Выводим значения массивов на экран
        System.out.println(agDoub.printObj());
        System.out.println(agInt.printObj());
        System.out.println(agStr.printObj());

        // 2 задание
        System.out.println("\n2 задание");
        // Создаем ArrayList
        ArrayList<Integer> alInt = new ArrayList<>();
        ArrayList<String> alStr = new ArrayList<>();
        ArrayList<Double> alDoub = new ArrayList<>();
        // Добавляем в ArrayList из Array
        agDoub.changeArrayOnArrayList(alDoub);
        agInt.changeArrayOnArrayList(alInt);
        agStr.changeArrayOnArrayList(alStr);
        // Выводим на экран
        System.out.println("ArrayList<Double>:");
        printArrayList(alDoub);
        System.out.println("ArrayList<String>:");
        printArrayList(alStr);
        System.out.println("ArrayList<Integer>:");
        printArrayList(alInt);
    }

    /**
     * Выводит на экран все значения ArrayList
     * @param al - ArrayList
     * @param <T>
     */
    static <T> void printArrayList(ArrayList<T> al) {
        for (T item: al) {
            System.out.println(item);
        }
    }



}
