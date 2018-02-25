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

    public static void main(String[] args) {
        ThreadPartOneHomeWork hw = new ThreadPartOneHomeWork();
        Thread tA = new Thread(() -> {
            hw.printA();
        });
        Thread tB = new Thread(() -> {
            hw.printB();
        });
        Thread tC = new Thread(() -> {
            hw.printC();
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
}
