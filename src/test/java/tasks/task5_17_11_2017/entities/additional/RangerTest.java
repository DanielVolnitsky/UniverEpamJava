package tasks.task5_17_11_2017.entities.additional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task5_17_11_2017.entities.basicAppliances.ElectricalAppliance;
import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class RangerTest {
    ElectricalAppliancesHandler handler;
    ElectricalAppliancesHandler.Ranger<Double> ranger;
    List<ElectricalAppliance> list;
    ElectricalAppliance ea1;
    ElectricalAppliance ea2;
    ElectricalAppliance ea3;

    @BeforeEach
    void initializeAppliance() {
        ea1 = new ElectricalAppliance();
        ea2 = new ElectricalAppliance();
        ea3 = new ElectricalAppliance();

        list = new ArrayList<>();
    }

    @Test
    void getAppliancesByParamInRange() {
        try {
            ea1.setWeight(1.5);
            ea2.setWeight(10.5);
            ea3.setWeight(9.5);
        } catch (InvalidWeightException e) {
            fail("Invalid weight values inserted.");
        }

        list.add(ea1);
        list.add(ea2);
        list.add(ea3);

        handler = new ElectricalAppliancesHandler(list);
        ElectricalAppliancesHandler.Ranger<Double> ranger = handler.new Ranger();

        String propertyName = "weight";
        double min = 2;
        double max = 10;

        List<ElectricalAppliance> selected = ranger.getAppliancesByParamInRange(propertyName, min, max);
        int expected = 1;
        int result = selected.size();

        assertEquals(expected, result);
    }
}