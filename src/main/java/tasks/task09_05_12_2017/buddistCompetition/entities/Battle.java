package tasks.task09_05_12_2017.buddistCompetition.entities;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class Battle extends Thread {
    private Monk monk1;
    private Monk monk2;
    private Battlefield battlefield;

    public Battle(Monk monk1, Monk monk2, Battlefield battlefield) {
        this.monk1 = monk1;
        this.monk2 = monk2;
        this.battlefield = battlefield;
    }

    public Monk getMonk1() {
        return monk1;
    }

    public Monk getMonk2() {
        return monk2;
    }

    @Override
    public void run() {
        System.out.println("Пошла драка между " + monk1 + " и " + monk2);
        Monk winner = null;
        switch (monk1.getChiEnergy().compareTo(monk2.getChiEnergy())) {
            case 1:
                winner = monk1;
                break;
            case -1:
                winner = monk2;
                break;
            case 0:
                winner = getRandomizedInt(0, 2) == 0 ? monk1 : monk2;
                break;
        }
        System.out.println("***В драке между " + monk1 + " и " + monk2 + " победил " + winner);
        battlefield.getMonksQueue().add(winner);
        battlefield.getCurrBattleCount().decrementAndGet();
        battlefield.getBattlesCount().incrementAndGet();
        // System.out.println("Очередь: " + battlefield.getMonksQueue());
        System.out.println("Боев в данный момент: " + battlefield.getCurrBattleCount());
    }
}
