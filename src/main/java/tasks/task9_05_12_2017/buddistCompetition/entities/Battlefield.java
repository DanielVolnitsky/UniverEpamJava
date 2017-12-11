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
    private List<Battle> roundBattles;

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
        List<Monk> contestants = new ArrayList<>();
        contestants.addAll(firstMonastery.monks);
        contestants.addAll(secMonastery.monks);
        System.out.println(contestants);
        Collections.shuffle(contestants);
        System.out.println(contestants + "\n");
        monksQueue.addAll(contestants);

        do {
           while(getMonksQueue().size() > 1){
               System.out.println("---Есть возможность начать новую битву---");
               if (monksQueue.size() % 2 == 0 || monksQueue.size() > 1) {
                   System.out.println("В очереди есть 2 человека");
                   Battle battle = new Battle(monksQueue.take(), monksQueue.take(), this);
                   battle.start();
               }
           }
           Thread.sleep(1000);
        } while (getMonksQueue().size() != 1 || currBattleCount.get() != 0);

        System.out.println("\nПобедитель: монах с чи " + monksQueue.peek().getChiEnergy() +
                " из монастыря " + monksQueue.peek().getMonastery().getName());
    }
}
