package tasks;

import tasks.helpers.ArithmeticHelper;
import tasks.task9_05_12_2017.buddistCompetition.entities.Battlefield;
import tasks.task9_05_12_2017.buddistCompetition.entities.Monastery;
import tasks.task9_05_12_2017.buddistCompetition.entities.Monk;
import tasks.task9_05_12_2017.buddistCompetition.entities.MonkFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Monastery monastery1 = new Monastery("Гуань-Инь");
        Monastery monastery2 = new Monastery("Гуань-Янь");

        for (int i = 0; i < 15; i++) {
            monastery1.addMonk(MonkFactory.getNextMonk());
            monastery2.addMonk(MonkFactory.getNextMonk());
        }

        Battlefield battlefield = new Battlefield(monastery1, monastery2);
        battlefield.startBattle();
    }
}
