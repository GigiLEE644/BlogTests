package com.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DISetterXML {
    private static class PaymentService {
        public void processPayment() {
            System.out.println("Processing payment...");
        }
    }

    private static class OrderService {
        private PaymentService paymentService;

        // Setter method
        public void setPaymentService(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        public void placeOrder() {
            System.out.println("Placing order...");
            paymentService.processPayment();
        }
    }

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml")) {
            OrderService orderService = context.getBean(OrderService.class);
            orderService.placeOrder();
        }
    }
}
