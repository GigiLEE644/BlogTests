package com.example6;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@ComponentScan
public class DILookup {
    @Service
    @Scope("prototype")
    private static class PaymentService {
        public PaymentService() {
            System.out.println("New PaymentService created: " + this);
        }

        public void processPayment() {
            System.out.println("Processing payment...");
        }
    }

    @Service
    private static abstract class OrderService {
        public OrderService() {}

        // Abstract lookup method – Spring will override this
        @Lookup
        protected abstract PaymentService getPaymentService();

        public void placeOrder() {
            System.out.println("Placing order...");
            PaymentService paymentService = getPaymentService(); // always new instance
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DILookup.class)) {
            OrderService orderService = context.getBean(OrderService.class);

            orderService.placeOrder();
            orderService.placeOrder();
            orderService.placeOrder();
        }
    }
}
