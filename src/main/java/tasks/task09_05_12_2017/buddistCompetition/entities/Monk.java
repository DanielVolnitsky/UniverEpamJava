package tasks.task09_05_12_2017.buddistCompetition.entities;

public class Monk {
    private Integer chiEnergy;
    private Monastery monastery;

    public Monk(int chiEnergy) throws IllegalArgumentException {
        setChiEnergy(chiEnergy);
    }

    public Monk(int chiEnergy, Monastery monastery) throws IllegalArgumentException {
        this(chiEnergy);
        this.monastery = monastery;
    }

    public Integer getChiEnergy() {
        return chiEnergy;
    }

    public void setChiEnergy(int chiEnergy) throws IllegalArgumentException {
        if (chiEnergy > -1)
            this.chiEnergy = chiEnergy;
        else
            throw new IllegalArgumentException("Энергия чи не должна быть отрицательной");
    }

    public Monastery getMonastery() {
        return monastery;
    }

    public void setMonastery(Monastery monastery) {
        this.monastery = monastery;
    }

    @Override
    public String toString() {
        return "{chi: " + chiEnergy + '}';
    }
}
