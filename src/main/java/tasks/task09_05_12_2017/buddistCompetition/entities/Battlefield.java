package tasks.task09_05_12_2017.buddistCompetition.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Battlefield {
    private static final short MAX_BATTLE_TIME = 100;

    private Monastery firstMonastery;
    private Monastery secMonastery;
    private BlockingQueue<Monk> monksQueue;
    private AtomicInteger currBattleCount;
    private AtomicInteger battlesCount;
    private Monk winner;

    {
        currBattleCount = new AtomicInteger(0);
        battlesCount = new AtomicInteger(0);
    }

    public Battlefield(Monastery firstMonastery, Monastery secMonastery) throws IllegalArgumentException{
        if (firstMonastery != null && secMonastery != null) {
            this.firstMonastery = firstMonastery;
            this.secMonastery = secMonastery;

            monksQueue = new ArrayBlockingQueue<>(
                    firstMonastery.monks.size() + secMonastery.monks.size());
        } else
            throw new IllegalArgumentException("Какой-то монастырь null, некому соревноваться");
    }

    AtomicInteger getCurrBattleCount() {
        return currBattleCount;
    }

    BlockingQueue<Monk> getMonksQueue() {
        return monksQueue;
    }

    AtomicInteger getBattlesCount() {
        return battlesCount;
    }

    public void startBattle() throws InterruptedException {
        organizeParticipants();
        do {
            Battle battle = new Battle(monksQueue.take(),
                    monksQueue.poll(MAX_BATTLE_TIME, TimeUnit.MILLISECONDS), this);

            if (battle.getMonk2() != null) {
                currBattleCount.incrementAndGet();
                battle.start();
            } else
                winner = battle.getMonk1();

        } while (getMonksQueue().size() > 1 || currBattleCount.get() > 0);

        System.out.println("\nПобедил монах с чи " + winner.getChiEnergy() +
                " из монастыря " + (winner.getMonastery() != null ? winner.getMonastery().getName() : "незивестный"));
        System.out.println("Всего боев проведено: " + battlesCount.get());
    }

    /*Создаем список претендентов на победу и соритруем их*/
    private void organizeParticipants() {
        List<Monk> contestants = new ArrayList<>(firstMonastery.monks);
        contestants.addAll(secMonastery.monks);

        System.out.println("Участники в начальном порядке: " + contestants);

        Collections.shuffle(contestants);
        monksQueue.addAll(contestants);

        System.out.println("Участники в случайном порядке: " + monksQueue);
        System.out.println("Всего участников: " + monksQueue.size() + "\n");
    }
}
