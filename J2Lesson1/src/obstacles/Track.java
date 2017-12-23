package obstacles;
import animals.*;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class Track {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    public boolean doIt(Animal animal) {
        return animal.run(length);
    } 
}