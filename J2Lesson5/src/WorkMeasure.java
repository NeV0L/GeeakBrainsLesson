/**
 * Write a description of class WorkMeasure here.
 *
 * @author Volsky Nikita
 * @version dated 10.01.18
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */

public class WorkMeasure {
    // size array
    private final int SIZE = 10000000;
    // half size array
    private final int HALF_SIZE = SIZE / 2;

    public void startMeasure() {
        // array of size SIZE
        float[] floatArray = new float[SIZE];

        fillArrayUnits(floatArray);
        // Note the start time
        long systemTimeStart = System.currentTimeMillis();

        sumArrayWithFormula(floatArray);
        // Note the finish time
        long systemTimeFinish = System.currentTimeMillis();
        // Display time for a work
        System.out.println(systemTimeFinish - systemTimeStart);
    }

    /**
     * The method fills the array with the units
     * @param arr - array for fill
     */
    private void fillArrayUnits(float[] arr) {
        if (arr != null){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
        }
    }

    /**
     * The method fill every element on the formula
     * @param arr - array for fill
     */
    private void sumArrayWithFormula(float[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
