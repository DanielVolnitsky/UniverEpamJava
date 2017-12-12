package tasks.task09_05_12_2017.beesAndPuch;

import tasks.task09_05_12_2017.beesAndPuch.entities.Beehive;
import tasks.task09_05_12_2017.beesAndPuch.entities.Forest;

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest(10, 10);
        Beehive beehive = new Beehive(3, forest);
        beehive.findPooh();
    }
}
