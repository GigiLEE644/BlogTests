package com.example18;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@ComponentScan
public class ResourceTypeBasedExample {
    private static class PaymentService {
        protected void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    @Component
    private static class CreditCardPaymentService extends PaymentService {
    }

    @Component
    private static class OrderService {
        @Resource
        private PaymentService paymentService;

        public void placeOrder() {
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ResourceTypeBasedExample.class);
        OrderService service = context.getBean(OrderService.class);
        service.placeOrder();
        context.close();
    }
}
