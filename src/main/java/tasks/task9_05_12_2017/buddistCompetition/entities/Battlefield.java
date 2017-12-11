package tasks.task9_05_12_2017.buddistCompetition.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Battlefield {
    private Monastery firstMonastery;
    private Monastery secMonastery;
    private BlockingQueue<Monk> monksQueue;
    private AtomicInteger currBattleCount;

    {
        currBattleCount = new AtomicInteger(0);
    }

    public Battlefield(Monastery firstMonastery, Monastery secMonastery) {
        this.firstMonastery = firstMonastery;
        this.secMonastery = secMonastery;

        monksQueue = new ArrayBlockingQueue<>(
                firstMonastery.monks.size() + secMonastery.monks.size());
    }

    public AtomicInteger getCurrBattleCount() {
        return currBattleCount;
    }

    public BlockingQueue<Monk> getMonksQueue() {
        return monksQueue;
    }

    public void startBattle() throws InterruptedException {
       // Thread.currentThread().setPriority(6);

        organizeParticipants();
        System.out.println("Учасники в случайном порядке: " + monksQueue);

        int round = 0;
        do {
            System.out.println("\nРАУНД " + ++round);
            while (getMonksQueue().size() > 1) {
               // System.out.println("Берутся 2 участника в очереди");
                Battle battle = new Battle(monksQueue.take(), monksQueue.take(), this);
                //battle.setPriority(5);
                battle.start();
            }
            Thread.sleep(500);
        } while (getMonksQueue().size() != 1 || currBattleCount.get() != 0);

        System.out.println("\nПобедил монах с чи " + monksQueue.peek().getChiEnergy() +
                " из монастыря " + monksQueue.peek().getMonastery().getName());
    }

    private void organizeParticipants() {
        List<Monk> contestants = new ArrayList<>(firstMonastery.monks);
        contestants.addAll(secMonastery.monks);
        System.out.println("Учасники в начальном порядке: " + contestants);
        Collections.shuffle(contestants);
        monksQueue.addAll(contestants);
    }
}
