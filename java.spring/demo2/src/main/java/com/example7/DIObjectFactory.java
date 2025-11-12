package com.example7;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ComponentScan
public class DIObjectFactory {

    @Component
    private static class OrderService {

        private final ObjectFactory<PaymentService> paymentServiceFactory;

        @Autowired
        public OrderService(ObjectFactory<PaymentService> paymentServiceFactory) {
            this.paymentServiceFactory = paymentServiceFactory;
        }

        public void placeOrder() {
            PaymentService paymentService = paymentServiceFactory.getObject(); // fresh instance each time
            paymentService.processPayment();
        }
    }

    @Component
    @Scope("prototype") // Prototype scope
    private static class PaymentService {
        public void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                DIObjectFactory.class)) {
            OrderService orderService = context.getBean(OrderService.class);

            orderService.placeOrder();
            orderService.placeOrder();
            orderService.placeOrder();
        }
    }
}
/*
 * Output:
 * Processing payment with instance: com.example7.DIObjectFactory$PaymentService@72d1ad2e
 * Processing payment with instance: com.example7.DIObjectFactory$PaymentService@399f45b1
 * Processing payment with instance: com.example7.DIObjectFactory$PaymentService@478190fc
 */