package com.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class IocAnnotationBased2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                IocAnnotationBased2.class);

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

        @jakarta.annotation.PostConstruct
        public void init() {
            this.message = "Hello World!";
        }
    }
}
