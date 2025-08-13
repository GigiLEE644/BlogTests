package com.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@ComponentScan
public class IocAnnotationBased3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                IocAnnotationBased3.class);

        GreetingService service = ctx.getBean(GreetingService.class);

        service.greet();

        ctx.close();
    }

    @Service
    private static class GreetingService {
        private String message;

        public void greet() {
            System.out.println(message);
        }

        @PostConstruct
        public void init() {
            this.message = "Hello World!";
        }
    }
}
