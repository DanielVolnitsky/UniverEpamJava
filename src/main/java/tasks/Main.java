package tasks;

import tasks.helpers.ArithmeticHelper;
import tasks.task9_05_12_2017.buddistCompetition.entities.Battlefield;
import tasks.task9_05_12_2017.buddistCompetition.entities.Monastery;
import tasks.task9_05_12_2017.buddistCompetition.entities.Monk;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Monastery monastery1 = new Monastery("Гуань-Инь");
        Monastery monastery2 = new Monastery("Гуань-Янь");

        for (int i = 0; i < 3; i++) {
            monastery1.addMonk(new Monk(ArithmeticHelper.getRandomizedInt(0, 100), monastery1));
        }
        for (int i = 0; i < 4; i++) {
            monastery2.addMonk(new Monk(ArithmeticHelper.getRandomizedInt(0, 100), monastery2));
        }
        Battlefield battlefield = new Battlefield(monastery1, monastery2);
        battlefield.startBattle();
    }
}
