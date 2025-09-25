package org.example;

class Order {
    String orderType;
}

class OrderService {
    public void deliver(Order order) {
        if (order.orderType.equals("courier")) {
            // ... логика доставки курьером ...
        } else if (order.orderType.equals("post")) {
            // ... логика доставки почтой ...
        } else if (order.orderType.equals("pickup")) {
            // ... логика самовывоза ...
        }
    }
}

public class OpenClosed {
    public static void main(String[] args) {

    }
}
