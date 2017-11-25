package tasks.task4_16_11_2017.entities;

import java.util.Date;

/**
 * Класс, содержащий данные прогноза погоды
 */
public class Forecast{

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forecast forecast = (Forecast) o;

        if (Double.compare(forecast.temp, temp) != 0) return false;
        if (Double.compare(forecast.humidity, humidity) != 0) return false;
        if (Double.compare(forecast.pressure, pressure) != 0) return false;
        if (Double.compare(forecast.windSpeed, windSpeed) != 0) return false;
        if (Double.compare(forecast.windGust, windGust) != 0) return false;
        if (Double.compare(forecast.windBearing, windBearing) != 0) return false;
        return date.equals(forecast.date);
    }

    @Override
    public int hashCode() {
        int result;
        long temp1;
        result = date.hashCode();
        temp1 = Double.doubleToLongBits(temp);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(humidity);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(pressure);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(windSpeed);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(windGust);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        temp1 = Double.doubleToLongBits(windBearing);
        result = 31 * result + (int) (temp1 ^ (temp1 >>> 32));
        return result;
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
