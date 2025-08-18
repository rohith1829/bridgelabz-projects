package foodorder.observer;

import java.util.*;

public class OrderTracker implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void updateStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(status);
        }
    }
}