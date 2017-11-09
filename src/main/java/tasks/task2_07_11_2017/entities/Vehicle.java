package tasks.task2_07_11_2017.entities;

import java.time.Year;

/** Высший в иерархии класс представляющий движущиеся механизмы
 * */
public abstract class Vehicle {
    private double price;

    /**Скорость (км/ч)*/
    private double velocity;
    private Year releaseYear;
    /**координата широты*/
    private double latitude;
    /**координата долготы*/
    private double longitude;

    public Vehicle() {

    }

    /**Сеттеры используются в конструкторе для дополнительных проверок вводимых значений*/
    public Vehicle(double price, double velocity, Year releaseYear, double latitude, double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
        setPrice(price);
        setVelocity(velocity);
        this.releaseYear = releaseYear;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if(latitude >= -90.0 && latitude <= 90.0)
            this.latitude = latitude;
        else
            throw new IllegalArgumentException("latitude must be between -90 and 90 degrees");
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if(longitude >= -180.0 && longitude <= 180.0)
            this.longitude = longitude;
        else
            throw new IllegalArgumentException("longitude must be between -90 and 90 degrees");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0.0)
            this.price = price;
        else
            throw new IllegalArgumentException("price has to be more that 0");
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        if(velocity >= 0.0)
            this.velocity = velocity;
        else
            throw new IllegalArgumentException("velocity has to be a positive value");
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "price = " + price + "$, velocity = " + velocity + "km/h, releaseYear = " + releaseYear +
                ", latitude = " + latitude + ", longitude = " + longitude;
    }
}
