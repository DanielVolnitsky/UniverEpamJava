package tasks.task5_17_11_2017.entities;

import tasks.task5_17_11_2017.exceptions.InvalidWeightException;

/**Класс представляет сущность прибора*/
public class Appliance {

    private String name;
    private double weight;

    /*Назначение прибора*/
    private String designation;

    {
        designation = "undefined";
    }

    public Appliance() {

    }

    public Appliance(String name, double weight) throws InvalidWeightException {
        setWeight(weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidWeightException {
        if (weight >= 0)
            this.weight = weight;
        else
            throw new InvalidWeightException();
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "name: '" + name + '\'' + ", weight: " + weight + "kg" + ", designation: '" + designation + '\'';
    }
}
