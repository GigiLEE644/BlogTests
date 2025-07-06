package com.example2;

import org.springframework.context.support.GenericApplicationContext;
import jakarta.annotation.PostConstruct;

public class BeanPostConstructTest {
    public static class Bean {
        @PostConstruct
        public void init() {
            System.out.println("PostConstruct called!");
        }
    }

    public static void main(String[] args) {
        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        GenericApplicationContext ctx = new GenericApplicationContext();
        ctx.registerBean(org.springframework.context.annotation.CommonAnnotationBeanPostProcessor.class);
        ctx.registerBean(Bean.class);
        ctx.refresh();
        ctx.close();
    }
}
