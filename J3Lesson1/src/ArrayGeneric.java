import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class ArrayGeneric<T> {
    T[] obj;

    public ArrayGeneric(T[] obj) {
        this.obj = obj;
    }

    /**
     * Метод выводит обходит массив и собирает все значения
     *
     * @return String - набор значений в массиве
     */
    public String printObj() {
        String result = "";

        for (int i = 0; i < obj.length; i++) {
            result += obj[i] + " ";
        }

        return result;
    }

    /**
     * Метод меняет местами значения массива
     *
     * @param index1 первый индекс массива
     * @param index2 второй индекс массива
     */
    public void changeIndex(int index1, int index2) {
        if (((index1 < obj.length) && (index1 > 0)) &&
                ((index2 < obj.length) && (index2 > 0))) {
            T objectTmp = obj[index1];
            obj[index1] = obj[index2];
            obj[index2] = objectTmp;
        }
    }

    /**
     * Метод добавляет значения из Array в ArrayList
     * @param al - ArrayList для добавления значений
     */
    public void changeArrayOnArrayList(ArrayList<T> al) {
        al = Arrays.asList(obj);
    }
}
