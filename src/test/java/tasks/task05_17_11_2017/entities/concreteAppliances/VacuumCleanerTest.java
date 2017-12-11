package tasks.task05_17_11_2017.entities.concreteAppliances;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.task05_17_11_2017.exceptions.InvalidVacuumCleanerContainerVolumeException;

class VacuumCleanerTest {

    VacuumCleaner vcleaner;

    @BeforeEach
    void initializeAppliance() {
        vcleaner = new VacuumCleaner();
    }

    @Test
    void setContainerVolume() {
        Assertions.assertThrows(InvalidVacuumCleanerContainerVolumeException.class, () -> {
            vcleaner.setContainerVolume(-7.8);
        });
    }
}