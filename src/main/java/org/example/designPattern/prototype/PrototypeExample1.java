package org.example.designPattern.prototype;

interface Shape extends Cloneable {
    Shape clone();
    void draw();
}

class Circle implements Shape{

    @Override
    public Shape clone() {
        return new Circle();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape{

    @Override
    public Shape clone() {
        return new Rectangle();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class PrototypeExample1 {

    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape circle2 = circle1.clone();

        Shape rectangle1 = new Rectangle();
        Shape rectangle2 = rectangle1.clone();

        circle1.draw();
        circle2.draw();
        rectangle1.draw();
        rectangle2.draw();
    }
}
