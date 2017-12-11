package tasks.task08_28_11_2017.entities;

public class Manufacturer {

    private String name;
    private String description;

    public Manufacturer() {

    }

    public Manufacturer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String manufacturerDescription) {
        this.description = manufacturerDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
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
