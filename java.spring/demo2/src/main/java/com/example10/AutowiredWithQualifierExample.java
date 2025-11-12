package com.example10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class AutowiredWithQualifierExample {
private static class PaymentService {
        protected void processPayment() {
            System.out.println("Processing payment with instance: " + this);
        }
    }

    @Component("PayPal")
    private static class PaypalPaymentService extends PaymentService {
    }

    @Component("CreditCard")
    private static class CreditCardPaymentService extends PaymentService {
    }

    @Component
    private static class OrderService {
        @Autowired
        @Qualifier("CreditCard")
        private PaymentService paymentService;

        public void placeOrder() {
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AutowiredWithQualifierExample.class);
        OrderService service = context.getBean(OrderService.class);
        service.placeOrder();
        context.close();
    }
}
/*
 * Output:
 * Processing payment with instance: com.example10.AutowiredWithQualifierExample$CreditCardPaymentService@158da8e
 */