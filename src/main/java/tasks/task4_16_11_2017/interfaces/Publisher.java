package tasks.task4_16_11_2017.interfaces;

/*Интерфейс, предназначенный для участников паттерна "Observer" - субъектов,
* оповещающих своих наблюдателей*/
public interface Publisher {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
