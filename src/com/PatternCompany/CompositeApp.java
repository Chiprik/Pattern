package com.PatternCompany;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new SquareComp();
        Shape square2 = new SquareComp();
        Shape triangle1 = new TriangleComp();

        Shape square3 = new SquareComp();
        Shape circle1 = new CircleComp();
        Shape circle2 = new CircleComp();
        Shape circle3 = new CircleComp();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.draw();
    }
}

interface Shape{
    void draw();
}

class SquareComp implements Shape{
    public void draw(){
        System.out.println("Привет, я Квадрат.");
    }
}
class TriangleComp implements Shape{
    public void draw(){
        System.out.println("Привет, я Треугольник.");
    }
}
class CircleComp implements Shape{
    public void draw(){
        System.out.println("Привет, я Круг.");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();
    public void addComponent(Shape component){
        components.add(component);
    }
    public void removeComponent(Shape component){
        components.remove(component);
    }
    public void draw(){
        for (Shape component:components) {
            component.draw();
        }

    }
}