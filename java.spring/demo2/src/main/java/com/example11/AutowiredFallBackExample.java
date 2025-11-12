package com.example11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class AutowiredFallBackExample {
    @Component("paymentService")
    private static class PaymentService {
        protected void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    @Component
    private static class PaypalPaymentService extends PaymentService {
    }

    @Component
    private static class CreditCardPaymentService extends PaymentService {
    }

    @Component
    private static class OrderService {
        @Autowired
        private PaymentService paymentService;

        public void placeOrder() {
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AutowiredFallBackExample.class);
        OrderService service = context.getBean(OrderService.class);
        service.placeOrder();
        context.close();
    }
}
/*
 * Output:
 * Processing payment with instance: com.example11.AutowiredFallBackExample$PaymentService@3ce1e309
 */