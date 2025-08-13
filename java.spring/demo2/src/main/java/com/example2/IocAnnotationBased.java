package com.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocAnnotationBased {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                IocAnnotationBased.class);

        GreetingService service = ctx.getBean(GreetingService.class);

        service.greet();

        ctx.close();
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService("Hello World!");
    }

    private static class GreetingService {
        private String message;

        public GreetingService(String message) {
            this.message = message;
        }

        public void greet() {
            System.out.println(message);
        }
    }
}
