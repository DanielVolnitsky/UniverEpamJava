package tasks.task4_16_11_2017.entities;

import tasks.task4_16_11_2017.exceptions.InvalidCoordinatesException;

/**
 * Класс определяет атрибуты местонахождения
 */
public class LocationInfo {

    private String countryName;
    private String city;
    private double latitude;
    private double longitude;

    public LocationInfo() {

    }

    public LocationInfo(String countryName, String city, double latitude, double longitude) throws InvalidCoordinatesException {
        this.countryName = countryName;
        this.city = city;
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) throws InvalidCoordinatesException {
        if (latitude >= -90.0 && latitude <= 90.0)
            this.latitude = latitude;
        else
            throw new InvalidCoordinatesException("latitude must be between -90 and 90 degrees");
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) throws InvalidCoordinatesException {
        if (longitude >= -180.0 && longitude <= 180.0)
            this.longitude = longitude;
        else
            throw new InvalidCoordinatesException("longitude must be between -90 and 90 degrees");
    }
}
