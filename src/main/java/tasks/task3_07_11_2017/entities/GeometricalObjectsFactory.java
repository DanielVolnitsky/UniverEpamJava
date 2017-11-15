package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class GeometricalObjectsFactory {
    /**
     * @return Возвращает случайно выбранный и сгенерированный объект типа Vehicle
     */
    public static GeometricalObject getRandomGeometricalObject() {
        return GeometricalObjectRandomizer.getRandomGeometricalObject();
    }
}
