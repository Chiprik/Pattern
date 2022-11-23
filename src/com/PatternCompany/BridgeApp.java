package com.PatternCompany;

public class BridgeApp {
    public static void main(String[] args) {
        CarBr c = new Sedan(new Kia());
        c.showDetailes();
    }
}

abstract class CarBr {
    Make make;

    public CarBr(Make m) {
        make =m;
    }
    abstract void showType();
    void showDetailes(){
        showType();
        make.setMake();
    }
}

class Sedan extends CarBr {
    public Sedan(Make m){
        super(m);
    }
    void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends CarBr {
    public Hatchback(Make m){
        super(m);
    }
    void showType() {
        System.out.println("Hatchback");
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {
    public void setMake() {
        System.out.println("Skoda");
    }
}