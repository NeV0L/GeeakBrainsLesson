package animals;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class Hen extends Animal implements Jumpable {
    public Hen(String name) {
        this.name = name;
        this.run_limit = 100;
        this.jump_limit = 10f;
        this.swim_limit = 0;
    }

    public String voice() {
        return "ko-ko-ko";
    }

    public boolean jump(float height) {
        return this.checkJumpLimit = this.jump_limit >= height;
    }
}