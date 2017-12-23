package animals;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class Hippo extends Animal implements Swimable {
    public Hippo(String name) {
        this.name = name;
        this.run_limit = 50;
        this.swim_limit = 200;
        this.jump_limit = 0;
    }

    public String voice() {
        return "uf-uf-uf";
    }

    public boolean swim(int length) {
        return this.checkSwimLimit = this.swim_limit >= length;
    }
}