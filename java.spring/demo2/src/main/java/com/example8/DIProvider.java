package com.example8;

import jakarta.inject.Provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ComponentScan
public class DIProvider {

    @Component
    private static class OrderService {

        private final Provider<PaymentService> paymentServiceProvider;

        public OrderService(Provider<PaymentService> paymentServiceProvider) {
            this.paymentServiceProvider = paymentServiceProvider;
        }

        public void placeOrder() {
            PaymentService paymentService = paymentServiceProvider.get(); // fresh instance
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
                DIProvider.class)) {
            OrderService orderService = context.getBean(OrderService.class);

            orderService.placeOrder();
            orderService.placeOrder();
            orderService.placeOrder();
        }
    }
}
/*
 * Output:
 * Processing payment with instance: com.example8.DIProvider$PaymentService@5158b42f
 * Processing payment with instance: com.example8.DIProvider$PaymentService@595b007d
 * Processing payment with instance: com.example8.DIProvider$PaymentService@72d1ad2e
 */