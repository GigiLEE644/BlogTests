package com.example5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
public class DIFieldInjection {
    @Service
    private static class PaymentService {
        public void processPayment() {
            System.out.println("Processing payment...");
        }
    }

    @Service
    private static class OrderService {

        // Field injection
        @Autowired
        private PaymentService paymentService;

        public void placeOrder() {
            System.out.println("Placing order...");
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIFieldInjection.class)) {
            OrderService orderService = context.getBean(OrderService.class);
            orderService.placeOrder();
        }
    }
}
/*
 * Output:
 * Placing order...
 * Processing payment...
 */