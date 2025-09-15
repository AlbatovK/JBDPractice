package org.example;

public class Main {

    public static void process(Flyable flyable) {
        flyable.fly();
    }

    public static void main(String[] args) {
        Bird crow = new Crow();
        Bird eagle = new Eagle();
        Plane plane = new Plane();
        process(crow);
        process(eagle);
        process(plane);
    }
}

interface Flyable {
    void fly();
}

abstract class Bird implements Flyable {
}


class Crow extends Bird {

    @Override
    public void fly() {
        System.out.println("Crow");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle");
    }
}

class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Plane");
    }
}






interface Drawable {
    void draw();
}

class Circle implements Drawable {

    @Override
    public void draw() {
        System.out.println("Draw Circle!");
    }
}


abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public abstract void move();

    public void display() {
        System.out.println(name + " vehicle: " + speed);
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void move() {
        System.out.println("Bicycle is moving!");
    }
}

//class Plane extends Vehicle {
//    public Plane(String name, int speed) {
//        super(name, speed);
//    }
//
//    @Override
//    public void move() {
//        System.out.println("Plane is flying!");
//    }
//}

class Counter {

    static {
        System.out.println("Counter");
    }

    public static int count = 0;

    public int a = 0;

    public static void change() {
        System.out.println("A");
    }

    public Counter(int a) {
        this.a = a;
        Counter.count++;
    }
}

class ChildCounter {
    public static void change() {
        System.out.println("B");
    }
}