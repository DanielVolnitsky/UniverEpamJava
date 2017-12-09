package tasks.task3_07_11_2017.entities;

import tasks.helpers.GeometricHelper;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

import java.io.Serializable;
import java.util.List;

/**
 * Класс представляет треугольник на плоскости
 *
 * @see Point
 * @see Line
 */
public class Triangle implements GeometricalObject, Serializable {
    /*вершины*/
    private Point apexA, apexB, apexC;
    /*линии*/
    private Line sideAB, sideBC, sideAC;

    /*Используем класс-обертку во избежание проблем с автоиниц. примитивных типов*/
    private Double perimeter;
    private Double area;

    protected Triangle() {

    }

    public Triangle(Line lineAB, Line lineBC, Line lineAC) throws IllegalArgumentException {
        if (canMakeTriangle(lineAB.getBeg(), lineAB.getEnd(), lineAC.getEnd())) {
            this.apexA = lineAB.getBeg();
            this.apexB = lineAB.getEnd();
            this.apexC = lineAC.getEnd();

            sideAB = lineAB;
            sideBC = lineBC;
            sideAC = lineAC;
        } else {
            throw new IllegalArgumentException("Невозможно составить треугольник из входящих линий.");
        }
    }

    public Triangle(Point apexA, Point apexB, Point apexC) throws IllegalArgumentException {
        if (canMakeTriangle(apexA, apexB, apexC)) {
            this.apexA = apexA;
            this.apexB = apexB;
            this.apexC = apexC;

            sideAB = new Line(apexA, apexB);
            sideBC = new Line(apexB, apexC);
            sideAC = new Line(apexA, apexC);
        } else {
            throw new IllegalArgumentException("Невозможно составить треугольник из входящих точек.");
        }
    }

    /**
     * Проверяет, возможно ли составить треугольник из заданных точек на основе проверок:
     * 1) на равенство любых двух точек между собой
     * 2) на нахождении 3 точек на одной прямой
     */
    public static boolean canMakeTriangle(Point apexA, Point apexB, Point apexC) {
        return !GeometricHelper.equalPoints(apexA, apexB, apexC) &&
                !GeometricHelper.isPointsOnSameLine(apexA, apexB, apexC);
    }

    public double getPerimeter() {
        if (perimeter == null) {
            this.perimeter = GeometricHelper.getTrianglePerimeter(this);
        }
        return perimeter;
    }

    public double getArea() {
        if (area == null) {
            this.area = GeometricHelper.getTriangleArea(this);
        }
        return area;
    }

    public Point getApexA() {
        return apexA;
    }

    public void setApexA(Point newApexA) {
        if (canMakeTriangle(newApexA, this.apexB, this.apexC)) {
            this.apexA = newApexA;
            sideAB = new Line(this.apexA, this.apexB);
            sideAC = new Line(this.apexA, this.apexC);
            nullifyDependentValues();
        } else {
            throw new IllegalArgumentException("Невозможно составить треугольник с точкой: " + newApexA);
        }
    }

    public Point getApexB() {
        return apexB;
    }

    public void setApexB(Point newApexB) {
        if (canMakeTriangle(this.apexA, newApexB, this.apexC)) {
            this.apexB = newApexB;
            sideAB = new Line(this.apexA, this.apexB);
            sideBC = new Line(this.apexB, this.apexC);
            nullifyDependentValues();
        } else {
            throw new IllegalArgumentException("Невозможно составить треугольник с заданной точкой." + newApexB);
        }
    }

    public Point getApexC() {
        return apexC;
    }

    public void setApexC(Point newApexC) {
        if (canMakeTriangle(this.apexA, this.apexB, newApexC)) {
            this.apexC = newApexC;
            sideBC = new Line(this.apexB, this.apexC);
            sideAC = new Line(this.apexA, this.apexC);
            nullifyDependentValues();
        } else {
            throw new IllegalArgumentException("Невозможно составить треугольник с заданной точкой." + newApexC);
        }
    }

    private void nullifyDependentValues() {
        this.perimeter = null;
        this.area = null;
    }

    public Line getSideAB() {
        return sideAB;
    }

    public Line getSideBC() {
        return sideBC;
    }

    public Line getSideAC() {
        return sideAC;
    }

    @Override
    public String toString() {
        return "triangle {" +
                "A: {" + apexA +
                "}, B: {" + apexB +
                "}, C: {" + apexC +
                "}, AB: " + sideAB +
                ", BC: " + sideBC +
                ", AC: " + sideAC +
                '}';
    }
}
