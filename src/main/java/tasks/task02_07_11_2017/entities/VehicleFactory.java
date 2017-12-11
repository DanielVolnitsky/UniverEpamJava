package tasks.task02_07_11_2017.entities;


/**
 * Представляет собой фабрику, для производства и получения объектов типа Vehicle
 *
 * @see Vehicle
 * @see VehicleRandomizer
 */
public class VehicleFactory {
    /**
     * @return Возвращает случайно выбранный и сгенерированный объект типа Vehicle
     */
    public Vehicle getRandomVehicle() {
        return VehicleRandomizer.getRandomVehicle();
    }
}
