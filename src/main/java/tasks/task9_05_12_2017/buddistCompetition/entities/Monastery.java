package tasks.task9_05_12_2017.buddistCompetition.entities;

import java.util.ArrayList;
import java.util.List;

public class Monastery {
    private String name;
    List<Monk> monks;

    {
        monks = new ArrayList<>();
    }

    public Monastery(String name) {
        this.name = name;
    }

    public Monastery(String name, List<Monk> monks) {
        this.name = name;
        this.monks = monks;
    }

    public String getName() {
        return name;
    }

    public List<Monk> getMonks() {
        return monks;
    }

    public void addMonk(Monk monk){
        if(monk != null){
            monk.setMonastery(this);
            monks.add(monk);
        }
    }
}
