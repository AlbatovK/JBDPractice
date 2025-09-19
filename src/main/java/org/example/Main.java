package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Bicycle bicycle = new Bicycle("Model");
//        Bicycle.HandleBar handleBar = bicycle.new HandleBar();
//        Bicycle.Seat seat = bicycle.new Seat();
//        bicycle.start();
//        handleBar.right();
//        seat.setup();

//        Library.Book book = new Library.Book("Title");
//        Library library = new Library("Address");
//        book.display();
//        library.display();

//        Button button = new Button();
//        button.addListener(
//                new Listener() {
//                    @Override
//                    public void onClick() {
//                        System.out.println("Popup");
//                    }
//                }
//        );
//        button.addListener(
//                new Listener() {
//                    @Override
//                    public void onClick() {
//                        System.out.println("Notification!");
//                    }
//                }
//        );
//
//        button.click();
//
//        Animal animal = new Animal() {
//            @Override
//            void makeSound() {
//                System.out.println("Animal sound");
//            }
//        };
//
//        animal.makeSound();

        Book book = new Book("Title", 10.0);
        System.out.println(book.price());
        System.out.println(book.title());
        System.out.println(book.toString());
        Book book1 = new Book("Title", 10.0);
        System.out.println(book1.equals(book));
    }
}

record Book(String title, double price) {
}

sealed class Vehicle permits Car, Bike {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }
}

sealed class Car extends Vehicle permits SportCar {

    public Car(String brand) {
        super(brand);
    }
}

non-sealed class SportCar extends Car {

    public SportCar(String brand) {
        super(brand);
    }
}

final class Bike extends Vehicle {

    public Bike(String brand) {
        super(brand);
    }
}


abstract class Animal {
    abstract void makeSound();
}

class Button {
    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener l) {
        listeners.add(l);
    }

    public void click() {
        for (Listener listener : listeners) {
            listener.onClick();
        }
    }
}

interface Listener {
    void onClick();
}

class PopupListener implements Listener {
    @Override
    public void onClick() {
        System.out.println("Popup");
    }
}

class NotificationListener implements Listener {
    @Override
    public void onClick() {
        System.out.println("Motification!");
    }
}


class Library {
    private String address;
    private static int a;

    public Library(String address) {
        this.address = address;
    }

    public void display() {
        System.out.println("Library " + this.address);
    }

    static class Book {
        private String title;

        public Book(String title) {
            this.title = title;
            System.out.println(a);
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void display() {
            System.out.println("Book " + title);
        }
    }
}


class Bicycle {
    private String model;

    public Bicycle(String model) {
        this.model = model;
    }

    public void start() {
        System.out.println("Start!");
    }

    private class HandleBar {
        public void right() {
            System.out.println("Right!" + model);
        }

        public void left() {
            System.out.println("Left!");
        }
    }

    private class Seat {
        public void setup() {
            System.out.println("Setup!");
            Bicycle.this.start();
        }
    }
}