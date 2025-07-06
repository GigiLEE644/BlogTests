package com.example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.*;
import org.springframework.context.support.GenericApplicationContext;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanLifeCycleTest2 {

    // Address bean to be injected into User
    public static class Address {
        private String city;

        public Address() {
            System.out.println("\nA1. Address constructor called");
        }

        public Address(String city) {
            this.city = city;
            System.out.println("\nA1. Address constructor with city called: " + city);
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            System.out.println("\nA2. setCity called with: " + city);
            this.city = city;
        }

        @Override
        public String toString() {
            return "Address{city='" + city + "'}";
        }
    }

    // User bean implements various lifecycle interfaces and annotations
    public static class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
        private String name;
        private Address address; // Dependency

        public User() {
            System.out.println("\n1. User constructor called");
        }

        // New constructor to set up the name and address
        public User(String name, Address address) {
            this.name = name;
            this.address = address;
            System.out.println("\n1. User constructor with name and address called: " + name + ", " + address);
        }

        public void setName(String name) {
            System.out.println("\n2. setName called with: " + name);
            this.name = name;
        }

        public String getName() {
            System.out.println("\ngetName called: " + name);
            return name;
        }

        public Address getAddress() {
            System.out.println("\ngetAddress called: " + address);
            return address;
        }

        public void setAddress(Address address) {
            System.out.println("\n2. setAddress called with: " + address);
            this.address = address;
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
            if (bean instanceof Address) {
                System.out.println("\nBeanPostProcessor#postProcessBeforeInitialization called for Address: " + beanName);
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) {
            if (bean instanceof User) {
                System.out.println("\nBeanPostProcessor#postProcessAfterInitialization called for: " + beanName);
            }
            if (bean instanceof Address) {
                System.out.println("\nBeanPostProcessor#postProcessAfterInitialization called for Address: " + beanName);
            }
            return bean;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n=== BeanLifeCycleTest2 main method started ===");

        GenericApplicationContext context = new GenericApplicationContext();

        // Register BeanPostProcessor
        context.registerBean(MyBeanPostProcessor.class);

        // Register Address bean
        context.registerBean(
            Address.class,
            () -> new Address("Shanghai"),
            beanDefinition -> {
                beanDefinition.setScope("singleton");
            }
        );

        // Register User bean using constructor injection for Address
        context.registerBean(
            User.class,
            () -> new User("Jane Doe", context.getBean(Address.class)),
            beanDefinition -> {
                beanDefinition.setScope("singleton");
                beanDefinition.setInitMethodName("customInit");
                beanDefinition.setDestroyMethodName("customDestroy");
            }
        );

        // Register CommonAnnotationBeanPostProcessor for @PostConstruct and @PreDestroy
        context.registerBean(org.springframework.context.annotation.CommonAnnotationBeanPostProcessor.class);

        context.refresh();

        User user = context.getBean(User.class);
        System.out.println("\nUser name: " + user.getName());
        System.out.println("\nUser address: " + user.getAddress());

        context.close();
        System.out.println("\n=== ApplicationContext closed ===");
    }
}
