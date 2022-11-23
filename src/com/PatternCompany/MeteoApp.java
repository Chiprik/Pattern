package com.PatternCompany;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class MeteoApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());

        station.setMeasurments(25, 760);
        station.setMeasurments(-5, 745);
    }
}

interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

class MeteoStation implements Observed {
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMeasurments(int t, int p) {
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer {
    public void handleEvent(int temp, int presser) {
        System.out.println("Погода изменилась. Температура = " + temp + ", давление = " + presser + ".");
    }
}
class FileObserver implements Observer{
    public void handleEvent(int temp, int presser) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Погода изменилась. Температура = "+ temp+ ", давление = "+ presser+ ".");
            pw.println();
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Погода изменилась. Температура = " + temp + ", давление = " + presser + ".");
    }
}
