package tasks;

import tasks.task03_07_11_2017.entities.demonstrators.SerializingDemonstrator;
import tasks.task09_05_12_2017.buddistCompetition.entities.Battlefield;
import tasks.task09_05_12_2017.buddistCompetition.entities.Monastery;
import tasks.task09_05_12_2017.buddistCompetition.entities.MonkFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SerializingDemonstrator demon = new SerializingDemonstrator();
        demon.demonstrate();
    }
}
