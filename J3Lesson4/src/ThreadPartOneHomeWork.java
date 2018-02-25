import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Write a description of class J3Lesson4 here.
 *
 * @author Volsky Nikita
 * @version dated 25.02.2018
 * @link https://github.com/NeV0L/
 */
public class ThreadPartOneHomeWork {
    // Обьект для синхронизации потоков
    private final Object monitor = new Object();
    // инициализация первой буквы
    private volatile char currentLetter = 'A';
    // количество повторений
    private final int counter = 5;
    // Записи для файла
    private ArrayList<String> arraysNote = new ArrayList<>();
    private final String noteOne = "Something has to be written here for the first record...";
    private final String noteTwo = "Something has to be written here for the second record...";
    private final String noteThree = "Something has to be written here for the third record...";
    private final String noteFour = "Something has to be written here for the fourth record...";
    private final String noteFive = "Something has to be written here for the fifth record...";
    private final String noteSix = "Something has to be written here for the sixth record...";
    private final String noteSeven = "Something has to be written here for the seventh record...";
    private final String noteEight = "Something has to be written here for the eighth record...";
    private final String noteNine = "Something has to be written here for the ninth record...";
    private final String noteTen = "Something has to be written here for the tenth record...";
    // Период записи в файл, 20 мс
    private final int duration = 20;
    // файл
    private final File fileThread = new File("fileThread.txt");

    public static void main(String[] args) {
        ThreadPartOneHomeWork hw = new ThreadPartOneHomeWork();
        hw.first();
        hw.second();
    }

    /**
     * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз, порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
     */
    void first() {
        Thread tA = new Thread(() -> {
            printA();
        });
        Thread tB = new Thread(() -> {
            printB();
        });
        Thread tC = new Thread(() -> {
            printC();
        });
        tA.start();
        tB.start();
        tC.start();
    }

    void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < counter; i++) {
                    while (currentLetter != 'A')
                        monitor.wait();
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < counter; i++) {
                    while (currentLetter != 'B')
                        monitor.wait();
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < counter; i++) {
                    while (currentLetter != 'C')
                        monitor.wait();
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук по 10 записей, с периодом в 20 мс)
     */
    void second() {
        appendArray();
        clearFile();

        Thread tA = new Thread(() -> {
            printFile("A");
        });
        Thread tB = new Thread(() -> {
            printFile("B");
        });
        Thread tC = new Thread(() -> {
            printFile("C");
        });
        tA.start();
        tB.start();
        tC.start();
    }

    /**
     * Очищаем файл перед заполнением
     */
    private void clearFile() {
        try (FileWriter file = new FileWriter(fileThread)) {
            file.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void printFile(String nameThread) {
        synchronized (monitor) {
            try (FileWriter file = new FileWriter(fileThread, true)) {
                for (String str: arraysNote) {
                    file.write(str + " by thread " + nameThread + ".\n");
                    monitor.wait(duration);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * добавляем записи для вывода в файл
     */
    private void appendArray() {
        arraysNote.add(noteOne);
        arraysNote.add(noteTwo);
        arraysNote.add(noteThree);
        arraysNote.add(noteFour);
        arraysNote.add(noteFive);
        arraysNote.add(noteSix);
        arraysNote.add(noteSeven);
        arraysNote.add(noteEight);
        arraysNote.add(noteNine);
        arraysNote.add(noteTen);
    }
}
