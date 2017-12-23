package animals;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class Cat extends Animal implements Jumpable, Swimable {
    public Cat(String name) {
        this.name = name;
        this.run_limit = 100;
        this.swim_limit = 100;
        this.jump_limit = 3.8f;
    }

    public String voice() {
        return "meow";
    }

    public boolean swim(int length) {
        return this.checkSwimLimit = this.swim_limit >= length;
    }

    public boolean jump(float height) {
        return this.checkJumpLimit = this.jump_limit >= height;
    }
}