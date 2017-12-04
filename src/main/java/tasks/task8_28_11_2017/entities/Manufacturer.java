package tasks.task8_28_11_2017.entities;

public class Manufacturer {

    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String manufacturerDescription) {
        this.description = manufacturerDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String manufacturerName) {
        this.name = manufacturerName;
    }

    @Override
    public String toString() {
        return "[description: " + description + ", name: " + name + "]";
    }
}
