package org.example;

public class InterfaceSegregation {
    public static void main(String[] args) {

    }
}

interface Printer {
    void printText(String text);

    void printImage(byte[] imageData);

    void printTable(String[][] tableData);
}

class TextPrinter implements Printer {
    @Override
    public void printText(String text) {
        // ... логика печати текста ...
    }

    @Override
    public void printImage(byte[] imageData) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    @Override
    public void printTable(String[][] tableData) {
        throw new UnsupportedOperationException("Метод не реализован");
    }
}

class ImagePrinter implements Printer {
    @Override
    public void printText(String text) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    @Override
    public void printImage(byte[] imageData) {
        // ... логика печати изображения ...
    }

    @Override
    public void printTable(String[][] tableData) {
        throw new UnsupportedOperationException("Метод не реализован");
    }
}

class TablePrinter implements Printer {
    @Override
    public void printText(String text) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    @Override
    public void printImage(byte[] imageData) {
        throw new UnsupportedOperationException("Метод не реализован");
    }

    @Override
    public void printTable(String[][] tableData) {
        // ... логика печати таблицы ...
    }
}
