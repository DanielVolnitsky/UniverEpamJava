package tasks.task11_12_12_2017.entities;

import java.util.List;

public class Polygon {

    private int id;
    private List<Point> points;

    protected Polygon() {

    }

    public Polygon(int id) {
        this.id = id;
    }

    public Polygon(int id, List<Point> points) throws IllegalArgumentException {
        this(id);
        setPoints(points);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Point> getPoints() {
        return this.points;
    }

    /**
     * @param points - входящий набор точек
     */
    public void setPoints(List<Point> points) throws IllegalArgumentException {
        if (points != null && points.size() > 3) {
            this.points = points;
        } else {
            throw new IllegalArgumentException("To build polygon more that 3 points needed.");
        }
    }

    @Override
    public String toString() {
        return "polygon {" +
                "points: " + points.toString() +
                '}';
    }
}
