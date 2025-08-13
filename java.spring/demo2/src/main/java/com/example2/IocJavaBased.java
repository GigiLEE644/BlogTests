package com.example2;

import org.springframework.context.support.GenericApplicationContext;

public class IocJavaBased {
    public static void main(String[] args) {
        GenericApplicationContext ctx = new GenericApplicationContext();

        ctx.registerBean(GreetingService.class, () -> new GreetingService("Hello World!"));

        ctx.refresh();

        GreetingService service = ctx.getBean(GreetingService.class);

        service.greet();

        ctx.close();
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
