package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.interfaces.GeometricalObject;

import static tasks.helpers.GeometricHelper.equalPoints;

public class Line implements GeometricalObject {
    private Point beg;
    private Point end;

    protected Line() {

    }

    public Line(Point beg, Point end) {
        setBeg(beg);
        setEnd(end);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Point getBeg() {
        return beg;
    }


    public void setBeg(Point newBeg) {
        /*концы отрезка не должны совпадать по координатам*/
        if (!equalPoints(newBeg, this.end))
            this.beg = newBeg;
        else
            throw new IllegalArgumentException("Координаты точек отрезка не должны совпадать.");
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point newEnd) {
        /*концы отрезка не должны совпадать по координатам*/
        if (!equalPoints(newEnd, this.beg))
            this.end = newEnd;
        else
            throw new IllegalArgumentException("Координаты точек отрезка не должны совпадать.");
    }

    @Override
    public String toString() {
        return "line {" + beg + ", " + end + '}';
    }
}