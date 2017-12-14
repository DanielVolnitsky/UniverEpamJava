package tasks.task11_12_12_2017.entities;

import java.util.Objects;

public class Point {
    private int id;
    private int x;
    private int y;

    public Point() {

    }

    public Point(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return id == point.id &&
                x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, x, y);
    }

    @Override
    public String toString() {
        return "point: [" + x + ", " + y + "]";
    }
}
