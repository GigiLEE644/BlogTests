package com.example9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ComponentScan
public class AutowiredWithPrimaryExample {
    private static class PaymentService {
        protected void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    @Component
    private static class PaypalPaymentService extends PaymentService {
    }

    @Component
    @Primary
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
                AutowiredWithPrimaryExample.class);
        OrderService service = context.getBean(OrderService.class);
        service.placeOrder();
        context.close();
    }
}
/*
 * Output:
 * Processing payment with instance: com.example9.AutowiredWithPrimaryExample$CreditCardPaymentService@47af7f3d
 */