package tasks.task5_17_11_2017.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task5_17_11_2017.entities.basicAppliances.Appliance;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

class ApplianceTest {
    Appliance appliance;

    @BeforeEach
    void initializeAppliance() {
        appliance = new Appliance();
    }

    @Test
    void setWeight() {
        Assertions.assertThrows(InvalidWeightException.class, () -> {
            appliance.setWeight(-2);
        });
    }
}