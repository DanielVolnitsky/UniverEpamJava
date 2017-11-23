package tasks.task5_17_11_2017.entities.additional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task5_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.InvalidPowerValueException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ElectricalAppliancesHandlerTest {

    ElectricalAppliancesHandler handler;
    List<ElectricalAppliance> list;
    ElectricalAppliance ea1;
    ElectricalAppliance ea2;
    ElectricalAppliance ea3;

    @BeforeEach
    void initializeAppliances() {

        ea1 = new ElectricalAppliance();
        ea2 = new ElectricalAppliance();
        ea3 = new ElectricalAppliance();

        list = new ArrayList<>();
    }

    @Test
    void getOverallPower() {
        try {
            ea1.setPower(800);
            ea2.setPower(300);
            ea3.setPower(200);
        } catch (InvalidPowerValueException e) {
            fail("Invalid power values inserted.");
        }

        list.add(ea1);
        list.add(ea2);
        list.add(ea3);
        handler = new ElectricalAppliancesHandler(list);

        int expected = 0;
        int result = handler.getOverallConsumedPower();

        assertEquals(expected, result);
    }
}