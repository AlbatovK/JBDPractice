package org.example;

import java.util.Objects;

class Container<T> implements Containable<T> {
    private T data;

    public Container(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class Pair<K, V> {
    K key;
    V value;
}

interface Containable<T> {
    void setData(T value);
    T getData();
}

class StringContainer implements Containable<String> {
    @Override
    public void setData(String value) {

    }

    @Override
    public String getData() {
        return null;
    }
}

class Car implements Comparable<Car> {
    String model;

    @Override
    public int compareTo(Car o) {
        return model.compareTo(o.model);
    }

    public Car(String model) {
        this.model = model;
    }
}

public class Main {
    public static void main(String[] args) {
    
    }

    public static <T> T findFirst(T[] array) {
        if (array.length == 0) {
            return null;
        }
        return array[0];
    }

    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array.length == 0) {
            return null;
        }
        T max = array[0];
        for (T obj: array) {
            if (obj.compareTo(max) > 0) {
                max = obj;
            }
        }
        return max;
    }
}
