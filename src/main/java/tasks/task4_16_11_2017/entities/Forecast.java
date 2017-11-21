package tasks.task4_16_11_2017.entities;

import java.util.Date;

/**
 * Класс, содержащий данные прогноза погоды
 */
public class Forecast {

    Date date;
    double temp;

    public Forecast() {

    }

    public Forecast(Date date, double temp) {
        this.date = date;
        this.temp = temp;
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
    public String toString(){
        return "Date: " + date.toString() + "\nTemperature for this hour: " + temp + " c\n";
    }
}
