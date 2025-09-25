package org.example;

class OrderService {

    public void deliver(String deliveryType) {
        if (deliveryType.equals("courier")) {
            // ... логика доставки курьером ...
        } else if (deliveryType.equals("post")) {
            // ... логика доставки почтой ...
        } else if (deliveryType.equals("pickup")) {
            // ... логика самовывоза ...
        }
    }
}

public class OpenClosed {
    public static void main(String[] args) {

    }
}
