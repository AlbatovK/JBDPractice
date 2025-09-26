package org.example;

class Order {
    String orderType;
}

interface DeliveryService {
    void deliver(Order order);
}

class CourierDeliveryService implements DeliveryService {
    @Override
    public void deliver(Order order) {
        // ... логика доставки курьером ...
    }
}

class PostDeliveryService implements DeliveryService {
    @Override
    public void deliver(Order order) {
        // ... логика доставки почтой ...
    }
}

class TaxiDeliveryService implements DeliveryService {
    @Override
    public void deliver(Order order) {
        // .. доставка такси
    }
}

class OrderService {
    public void deliver(DeliveryService service, Order order) {
        // .. доп логика
        service.deliver(order);
    }
}

public class OpenClosed {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        service.deliver(new TaxiDeliveryService(), new Order());
    }
}
