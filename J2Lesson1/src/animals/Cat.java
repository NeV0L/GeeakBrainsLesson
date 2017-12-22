package animals;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class Cat extends Animal implements Jumpable, Swimable {
    private int swim_limit;
    private float jump_limit;

    public Cat(String name) {
        this.name = name;
        this.run_limit = 100;
        swim_limit = 100;
        jump_limit = 3.8f;
    }

    public String voice() {
        return "meow";
    }

    public boolean swim(int length) {
        return swim_limit >= length;
    }

    public boolean jump(float height) {
        return jump_limit >= height;
    }
}