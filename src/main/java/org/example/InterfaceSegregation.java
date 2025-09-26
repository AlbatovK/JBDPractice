package org.example;

public class InterfaceSegregation {
    public static void main(String[] args) {

    }
}

interface TextPrinterInterface {
    void printText(String text);
}

interface PdfPrinterInterface {

}

class TextImagePrinter implements TextPrinterInterface, ImagePrinterInterface, TablePrinterInterface {
    @Override
    public void printTable(String[][] tableData) {

    }

    @Override
    public void printText(String text) {

    }

    @Override
    public void printImage(byte[] imageData) {

    }
}

interface ImagePrinterInterface {
    void printImage(byte[] imageData);
}

interface TablePrinterInterface {
    void printTable(String[][] tableData);
}

class TextPrinter implements TextPrinterInterface {
    @Override
    public void printText(String text) {
        // ... логика печати текста ...
    }
}

class ImagePrinter implements ImagePrinterInterface {

    @Override
    public void printImage(byte[] imageData) {
        // ... логика печати изображения ...
    }

}

class TablePrinter implements TablePrinterInterface {
    @Override
    public void printTable(String[][] tableData) {
        // ... логика печати таблицы ...
    }
}
