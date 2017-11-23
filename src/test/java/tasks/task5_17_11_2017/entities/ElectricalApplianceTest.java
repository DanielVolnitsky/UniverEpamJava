package tasks.task5_17_11_2017.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task5_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ElectricalApplianceTest {

    ElectricalAppliance appliance;

    @BeforeEach
    void initializeAppliance() {
        appliance = new ElectricalAppliance();
    }

    @Test
    void setPower() {
        Assertions.assertThrows(InvalidPowerValueException.class, () -> {
            appliance.setPower(-8);
        });
    }

    @Test
    void compareTo() {
        ElectricalAppliance appliance2 = new ElectricalAppliance();
        try {
            appliance.setPower(499);
            appliance2.setPower(500);
        } catch (InvalidPowerValueException e) {
            fail("Invalid power value provided.");
        }
        int expected = 1;
        int result = appliance2.compareTo(appliance);

        assertEquals(expected, result);
    }
}