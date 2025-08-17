package com.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DILookupXML {
    private static class PaymentService {
        public PaymentService() {
            System.out.println("New PaymentService created: " + this);
        }

        public void processPayment() {
            System.out.println("Processing payment...");
        }
    }

    private static abstract class OrderService {
        public OrderService() {}
        
        // abstract method for lookup
        protected abstract PaymentService getPaymentService();

        public void placeOrder() {
            System.out.println("Placing order...");
            PaymentService paymentService = getPaymentService();
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("beans4.xml")) {

            OrderService orderService = context.getBean(OrderService.class);

            orderService.placeOrder();
            orderService.placeOrder();
            orderService.placeOrder();
        }
    }
}
