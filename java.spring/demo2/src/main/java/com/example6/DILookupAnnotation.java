package com.example6;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@ComponentScan
public class DILookupAnnotation {
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
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DILookupAnnotation.class)) {
            OrderService orderService = context.getBean(OrderService.class);

            orderService.placeOrder();
            orderService.placeOrder();
            orderService.placeOrder();
        }
    }
}
/*
 * Output:
 * Placing order...
 * New PaymentService created: com.example6.DILookupAnnotation$PaymentService@69fb6037
 * Processing payment...
 * Placing order...
 * New PaymentService created: com.example6.DILookupAnnotation$PaymentService@36d585c
 * Processing payment...
 * Placing order...
 * New PaymentService created: com.example6.DILookupAnnotation$PaymentService@87a85e1
 * Processing payment...
 */