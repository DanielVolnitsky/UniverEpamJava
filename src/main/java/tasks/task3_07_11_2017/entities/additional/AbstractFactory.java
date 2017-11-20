package tasks.task3_07_11_2017.entities.additional;

import tasks.task3_07_11_2017.interfaces.GeometricalObject;

/**
 * Базовый класс для фабрик геометрических фигур
 *
 * @see GeometricalFactory
 * @see ColoredGeometricalFactory
 */
public abstract class AbstractFactory {
    public abstract GeometricalObject createGeometricalObject();
}
