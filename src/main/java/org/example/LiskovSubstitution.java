package org.example;

public class LiskovSubstitution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 3);
        Square square = new Square(5);

        System.out.println("Площадь прямоугольника: " + calculateArea(rectangle));

        System.out.println("Площадь квадрата: " + calculateArea(square));

        square.setHeight(10);
        System.out.println("Площадь квадрата после изменения ширины: " + calculateArea(square));
    }

    public static double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double calculateArea() {
        return width * height;
    }
}

class Square implements Shape {

    private double side;

    public void setHeight(double height) {
        this.side = height;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    public Square(double side) {
        this.side = side;
    }
}
