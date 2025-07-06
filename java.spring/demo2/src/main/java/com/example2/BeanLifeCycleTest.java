package com.example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.*;
import org.springframework.context.support.GenericApplicationContext;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanLifeCycleTest {

    // User bean implements various lifecycle interfaces and annotations
    public static class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
        private String name;

        public User() {
            System.out.println("\n1. User constructor called");
        }

        public void setName(String name) {
            System.out.println("\n2. setName called with: " + name);
            this.name = name;
        }

        public String getName() {
            System.out.println("\ngetName called: " + name);
            return name;
        }

        // Awareness callbacks
        @Override
        public void setBeanName(String name) {
            System.out.println("\n3. BeanNameAware#setBeanName called: " + name);
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            System.out.println("\n4. BeanFactoryAware#setBeanFactory called with: " + beanFactory);
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println("\n5. ApplicationContextAware#setApplicationContext called with: " + applicationContext);
        }

        // Initialization callbacks
        @PostConstruct
        public void postConstruct() {
            System.out.println("\n6. @PostConstruct called");
        }

        @Override
        public void afterPropertiesSet() {
            System.out.println("\n7. InitializingBean#afterPropertiesSet called");
        }

        public void customInit() {
            System.out.println("\n8. custom init-method called");
        }

        // Destruction callbacks
        @PreDestroy
        public void preDestroy() {
            System.out.println("\n9. @PreDestroy called");
        }

        @Override
        public void destroy() {
            System.out.println("\n10. DisposableBean#destroy called");
        }

        public void customDestroy() {
            System.out.println("\n11. custom destroy-method called");
        }
    }

    // BeanPostProcessor to show before/after initialization hooks
    public static class MyBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) {
            if (bean instanceof User) {
                System.out.println("\nBeanPostProcessor#postProcessBeforeInitialization called for: " + beanName);
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) {
            if (bean instanceof User) {
                System.out.println("\nBeanPostProcessor#postProcessAfterInitialization called for: " + beanName);
            }
            return bean;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n=== BeanLifeCycleTest main method started ===");

        GenericApplicationContext context = new GenericApplicationContext();

        // Register BeanPostProcessor
        context.registerBean(MyBeanPostProcessor.class);

        // Register User bean with all lifecycle hooks
        context.registerBean(
            User.class,
            User::new,
            beanDefinition -> {
                beanDefinition.setScope("singleton");
                beanDefinition.setInitMethodName("customInit");
                beanDefinition.setDestroyMethodName("customDestroy");
            }
        );

        context.addBeanFactoryPostProcessor(beanFactory -> 
            beanFactory.addBeanPostProcessor(new org.springframework.context.annotation.CommonAnnotationBeanPostProcessor())
        );

        context.refresh();

        User user = context.getBean(User.class);
        user.setName("John Doe");
        System.out.println("\nUser name: " + user.getName());

        context.close();
        System.out.println("\n=== ApplicationContext closed ===");
    }
}
