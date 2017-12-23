package obstacles;

import animals.Animal;

/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class Course {
    private Track track;
    private Wall wall;
    private Water water;

    public Course() {
        track = new Track(80);
        wall = new Wall(3);
        water = new Water(10);
    }

    public void doIt(Animal[] teamAnimal) {
        for (Animal animal: teamAnimal) {
            track.doIt(animal);
            wall.doIt(animal);
            water.doIt(animal);
        }

    }
}
