package com.PatternCompany;

import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<ShapeFly> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("круг"));
        shapes.add(shapeFactory.getShape("точка"));
        shapes.add(shapeFactory.getShape("квадрат"));
        shapes.add(shapeFactory.getShape("круг"));

        Random rand = new Random();
        for (ShapeFly shape: shapes) {
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            shape.drow(x,y);
        }

    }
}

//Flyweight
interface ShapeFly {
    void drow(int x, int y);
}

//Point Flyweight
class PointFly implements ShapeFly {
    public void drow(int x, int y) {
        System.out.println("(" + x + ", " + y + ") : рисуем точку");
    }
}

//Circle Flyweight
class CircleFly implements ShapeFly {
    int r = 5;

    public void drow(int x, int y) {
        System.out.println("(" + x + ", " + y + ") : рисуем круг радиусом " + r);
    }
}

//Circle Flyweight
class SquareFly implements ShapeFly {
    int a = 10;

    public void drow(int x, int y) {
        System.out.println("(" + x + ", " + y + ") : рисуем квадрат со стороной " + a);
    }
}

class ShapeFactory {
    private static final Map<String, ShapeFly> shapes = new HashMap<>();

    public ShapeFly getShape(String shapeName) {
        ShapeFly shape = shapes.get(shapeName);
        if (shape == null) {
            switch (shapeName) {
                case "круг":
                    shape = new CircleFly();
                    break;
                case "квадрат":
                    shape = new SquareFly();
                    break;
                case "точка":
                    shape = new PointFly();
                    break;

            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }

}