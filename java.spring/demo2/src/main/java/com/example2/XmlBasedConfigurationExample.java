package com.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBasedConfigurationExample {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        GreetingService service = ctx.getBean("gs", GreetingService.class);

        service.greet();

        ctx.close();
    }

    private static class GreetingService {
        private String message;

        public void setMessage(String message) {
            this.message = message;
        }

        public void greet() {
            System.out.println(message);
        }
    }
}
