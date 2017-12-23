package animals;

/**
 * Write a description of class J2Lesson1 here.
 *
 * @author Volsky Nikita
 * @version dated Dec 22, 2017
 * @link https://github.com/NeV0L/GeeakBrainsLesson
 */
public class TeamAnimal {
    // Список животных в команде
    private Animal[] teamAnimal;
    // Наименование команды
    private String nameTeam;

    public TeamAnimal(String nameTeam) {
        this.setNameTeam(nameTeam);
    }

    public String getNameTeam() {
        return "Команда \"" + this.nameTeam + "\"";
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public Animal[] getTeamAnimal() {
        if (teamAnimal.length == 0)
            System.err.println("Команда животных пустая");

        return teamAnimal;
    }

    public void setTeamAnimal(Animal[] teamAnimal) {
        this.teamAnimal = teamAnimal;
    }

    /**
     * Метод выводит информацию о команде на консоль
     */
    public void infoTeam() {
        String resultMsg = getNameTeam() + ":\n";

        for (Animal animal: teamAnimal) {
            resultMsg = resultMsg + animal.toString() +
                    ", может пробежать: " + animal.run_limit +
                    ", прыгнуть на: " + animal.jump_limit +
                    ", проплыть на: " + animal.swim_limit + "\n";
        }

        System.out.println(resultMsg);
    }

    /**
     * Метод выводит информацию о прохождении командой испытаний на консоль
     */
    public void checkCourseTeam() {
        String resultMsg = getNameTeam() + ":\n";

        for (Animal animal: teamAnimal) {
            resultMsg = resultMsg + animal.toString() +
                    ", пробежал: " + animal.checkRunLimit +
                    ", прыгнул: " + animal.checkJumpLimit +
                    ", проплыл: " + animal.checkSwimLimit + "\n";
        }

        System.out.println(resultMsg);
    }



}
