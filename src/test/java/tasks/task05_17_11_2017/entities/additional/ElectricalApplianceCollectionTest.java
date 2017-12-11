package tasks.task05_17_11_2017.entities.additional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectricalApplianceCollectionTest {

    @Test
    void add() {
        House.ElectricalApplianceCollection homeCollection = new House().new ElectricalApplianceCollection();
        homeCollection.add(null);

        int expected = 0;
        int result = homeCollection.getElectricalAppliances().size();

        assertEquals(expected, result);
    }
}