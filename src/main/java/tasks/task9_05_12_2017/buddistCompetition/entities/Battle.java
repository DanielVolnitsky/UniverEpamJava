package tasks.task9_05_12_2017.buddistCompetition.entities;

import tasks.helpers.ArithmeticHelper;

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

    @Override
    public void run() {
        battlefield.getCurrBattleCount().getAndIncrement();
        System.out.println("Пошла драка между " + monk1 + " и " + monk2);
        //Thread.sleep(ArithmeticHelper.getRandomizedInt(0, 1000));
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
        System.out.println("В драке между " + monk1 + " и " + monk2 + " победил " + winner);
        battlefield.getMonksQueue().add(winner);
        battlefield.getCurrBattleCount().getAndDecrement();
        System.out.println(winner + " вернулся в очередь");
        System.out.println(battlefield.getMonksQueue());
        interrupt();
    }
}
