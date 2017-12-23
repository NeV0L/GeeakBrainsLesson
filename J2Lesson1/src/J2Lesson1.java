import animals.*;
import obstacles.*;
/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class J2Lesson1 {
    
    public static void main(String[] args) {
        TeamAnimal teamAnimal = new TeamAnimal("Рожденные побеждать");
        Animal[] zoo = {new Cat("Murzik"), new Hen("Izzy"), new Hippo("Hippopo")};
        Course course = new Course();

        teamAnimal.setTeamAnimal(zoo);
        teamAnimal.infoTeam();
        course.doIt(zoo);
        teamAnimal.checkCourseTeam();
    }
   
}