package com.example14;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class AlternativeOptionalExample {
    // @Component
    private static class PaymentService {
        protected void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    @Component
    private static class OrderService {
        private PaymentService paymentService;

        @Autowired
        public OrderService(Optional<PaymentService> paymentService) {
            this.paymentService = paymentService.orElse(null);
        }

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
                AlternativeOptionalExample.class);
        OrderService service = context.getBean(OrderService.class);
        service.placeOrder();
        context.close();
    }
}
