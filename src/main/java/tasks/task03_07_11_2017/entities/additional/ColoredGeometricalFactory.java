package tasks.task03_07_11_2017.entities.additional;

import tasks.task03_07_11_2017.interfaces.GeometricalObject;

/**
 * Класс для создания цветный геом. фигур
 *
 * @see AbstractFactory
 */
public class ColoredGeometricalFactory extends AbstractFactory {

    @Override
    public GeometricalObject createGeometricalObject() {
        return GeometricalObjectRandomizer.getRandomColoredGeometricalObject();
    }
}
