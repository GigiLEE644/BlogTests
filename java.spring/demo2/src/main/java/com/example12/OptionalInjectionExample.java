package com.example12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class OptionalInjectionExample {
    // @Component
    private static class PaymentService {
        protected void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    @Component
    private static class OrderService {
        @Autowired(required = false)
        private PaymentService paymentService;

        public void placeOrder() {
            if (paymentService != null) {
                paymentService.processPayment();
            } else {
                System.out.println("No payment service available, proceeding without payment.");
            }
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                OptionalInjectionExample.class);
        OrderService service = context.getBean(OrderService.class);
        service.placeOrder();
        context.close();
    }
}
/*
 * Output:
 * No payment service available, proceeding without payment.
 */