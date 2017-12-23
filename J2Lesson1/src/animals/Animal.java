package animals;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public abstract class Animal {
    protected String name;
    protected int run_limit;
    protected int swim_limit;
    protected float jump_limit;
    // Флаги прохождения дистанции
    protected boolean checkRunLimit = false;
    protected boolean checkSwimLimit = false;
    protected boolean checkJumpLimit = false;

    public abstract String voice();

    public boolean run(int length) {
        return checkRunLimit = run_limit >= length;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + " " + name;
    }    
}