package com.example3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan
public class DIConstructorAnnotation {
    @Service
    private static class PaymentService {
        public void processPayment() {
            System.out.println("Processing payment...");
        }
    }

    @Service
    private static class OrderService {
        private final PaymentService paymentService;

        @Autowired // Optional if only one constructor
        public OrderService(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        public void placeOrder() {
            System.out.println("Placing order...");
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConstructorAnnotation.class)) {
            OrderService orderService = context.getBean(OrderService.class);
            orderService.placeOrder();
        }
    }
}
