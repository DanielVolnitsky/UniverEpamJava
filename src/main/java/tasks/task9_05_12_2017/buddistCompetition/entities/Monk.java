package tasks.task9_05_12_2017.buddistCompetition.entities;

public class Monk {
    private Integer chiEnergy;
    private Monastery monastery;

    public Monk(int chiEnergy) {
        this.chiEnergy = chiEnergy;
    }

    public Monk(int chiEnergy, Monastery monastery) {
        this.chiEnergy = chiEnergy;
        this.monastery = monastery;
    }

    public Integer getChiEnergy() {
        return chiEnergy;
    }

    public void setChiEnergy(int chiEnergy) {
        this.chiEnergy = chiEnergy;
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
