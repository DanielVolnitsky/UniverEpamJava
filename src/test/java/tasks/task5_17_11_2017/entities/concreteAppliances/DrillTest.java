package tasks.task5_17_11_2017.entities.concreteAppliances;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task5_17_11_2017.exceptions.InvalidMaxSpeedRotationException;

class DrillTest {
    Drill appliance;

    @BeforeEach
    void initializeAppliance() {
        appliance = new Drill();
    }

    @Test
    void setMaxRotationSpeed() {
        Assertions.assertThrows(InvalidMaxSpeedRotationException.class, () -> {
            appliance.setMaxRotationSpeed(-0.1);
        });
    }
}