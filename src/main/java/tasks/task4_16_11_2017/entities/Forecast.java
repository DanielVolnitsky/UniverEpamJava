package tasks.task4_16_11_2017.entities;

import java.util.Date;

/**
 * Класс, содержащий данные прогноза погоды
 */
public class Forecast {

    Date date;

    private double temp;
    private double humidity;
    private double pressure;

    private double windSpeed;
    private double windGust;
    private double windBearing;

    public Forecast() {

    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder(30);
        text.append(date);
        text.append("\n\nTemperature: ");
        text.append(this.getTemp());
        text.append("\nHumidity: ");
        text.append(this.getHumidity());
        text.append("\nPressure: ");
        text.append(this.getPressure());

        return text.toString();
    }
}
