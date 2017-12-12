package tasks.task09_05_12_2017.buddistCompetition.entities;

import org.junit.jupiter.api.Test;
import tasks.task09_05_12_2017.producerConsumer.entities.ProductCounter;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BattleTest {
    Battle battle;

    @Test
    void setBattlefield() {
        assertThrows(IllegalArgumentException.class, () -> {
            battle = new Battle(new Monk(1), new Monk(1), null);
        });
    }

    @Test
    void setMonk1() {
        assertThrows(IllegalArgumentException.class, () -> {
            battle = new Battle(null, new Monk(1), new Battlefield(null, null));
        });
    }
//
//    @Test
//    void setMonk2() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            battle = new Battle(new Monk(1), null, new Battlefield(null, null));
//        });
//    }
}