package tasks.task03_07_11_2017.entities.additional;

import tasks.task03_07_11_2017.interfaces.GeometricalObject;

/**
 * Клас для создания стандартных (бесцветных) геом. фигур
 *
 * @see AbstractFactory
 */
public class GeometricalFactory extends AbstractFactory {

    @Override
    public GeometricalObject createGeometricalObject() {
        return GeometricalObjectRandomizer.getRandomGeometricalObject();
    }
}
