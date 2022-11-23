package com.PatternCompany;

public class DelegateApp {
    public static void main(String[] args) {
//        A a = new A();
//        a.f();
        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.drow();

        painter.setGraphics(new Square());
        painter.drow();
    }
}

//class A{
//    void f(){
//        System.out.println("f()");
//    }
//}
//
//class B{
//    A a = new A();
//    void f(){
//        a.f();
//    }
//}

interface Graphics{
    default void draw(){

    }
}

class Triangle implements Graphics{
    public void draw(){
        System.out.println("Рисуем треугольник");
    }
}

class Square implements Graphics {
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

class Circle implements Graphics {
    public void draw() {
        System.out.println("Рисуем круг");
    }
}

class Painter{
    Graphics graphics;
    void setGraphics(Graphics g){
        graphics = g;
    }
    void drow(){
        graphics.draw();
    }
}