package com.example2;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanLifeCycleTest3 {

    // User bean implements various lifecycle interfaces and annotations
    public static class User implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
        private String name;

        public User() {
            System.out.println("\n4. User constructor called");
        }

        public void setName(String name) {
            System.out.println("\n7. setName called with: " + name);
            this.name = name;
        }

        public String getName() {
            System.out.println("\ngetName called: " + name);
            return name;
        }

        // Awareness callbacks
        @Override
        public void setBeanName(String name) {
            System.out.println("\n8. BeanNameAware#setBeanName called: " + name);
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            System.out.println("\n9. BeanFactoryAware#setBeanFactory called with: " + beanFactory);
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println("\n10. ApplicationContextAware#setApplicationContext called with: " + applicationContext);
        }

        // Initialization callbacks
        @PostConstruct
        public void postConstruct() {
            System.out.println("\n13. @PostConstruct called");
        }

        @Override
        public void afterPropertiesSet() {
            System.out.println("\n14. InitializingBean#afterPropertiesSet called");
        }

        public void customInit() {
            System.out.println("\n15. custom init-method called");
        }

        // Destruction callbacks
        @PreDestroy
        public void preDestroy() {
            System.out.println("\n18. @PreDestroy called");
        }

        @Override
        public void destroy() {
            System.out.println("\n19. DisposableBean#destroy called");
        }

        public void customDestroy() {
            System.out.println("\n20. custom destroy-method called");
        }
    }

    // BeanPostProcessor to show before/after initialization hooks
    public static class MyBeanPostProcessor implements BeanPostProcessor {
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) {
            if (bean instanceof User) {
                System.out.println("\n11. BeanPostProcessor#postProcessBeforeInitialization called for: " + beanName);
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) {
            if (bean instanceof User) {
                System.out.println("\n16. BeanPostProcessor#postProcessAfterInitialization called for: " + beanName);
            }
            return bean;
        }
    }

    // InstantiationAwareBeanPostProcessor to show instantiation and property population hooks
    public static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (beanClass == User.class) {
                System.out.println("\n2. InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: " + beanName);
            }
            return null; // return null to proceed with default instantiation
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (bean instanceof User) {
                System.out.println("\n5. InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: " + beanName);
            }
            return true; // continue with property population
        }

        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            if (bean instanceof User) {
                System.out.println("\n6. InstantiationAwareBeanPostProcessor#postProcessProperties called for: " + beanName);
            }
            return pvs;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n1. === BeanLifeCycleTest main method started ===");

        GenericApplicationContext context = new GenericApplicationContext();

        // Register InstantiationAwareBeanPostProcessor
        context.addBeanFactoryPostProcessor(beanFactory ->
            beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor())
        );

        // Step 3: Bean definition registered (added for clarity)
        System.out.println("\n3. User bean definition registered");

        // Register BeanPostProcessor
        context.registerBean(MyBeanPostProcessor.class);

        // Register User bean with all lifecycle hooks
        context.registerBean(
            User.class,
            User::new,
            beanDefinition -> {
                beanDefinition.setScope("prototype");
                beanDefinition.setInitMethodName("customInit");
                beanDefinition.setDestroyMethodName("customDestroy");
            }
        );

        // Register CommonAnnotationBeanPostProcessor for @PostConstruct and @PreDestroy
        context.addBeanFactoryPostProcessor(beanFactory -> 
            beanFactory.addBeanPostProcessor(new org.springframework.context.annotation.CommonAnnotationBeanPostProcessor())
        );

        context.refresh();

        User user = context.getBean(User.class);
        user.setName("John Doe");
        System.out.println("\n12. User name: " + user.getName());

        context.close();
        System.out.println("\n17. === ApplicationContext closed ===");
    }
}