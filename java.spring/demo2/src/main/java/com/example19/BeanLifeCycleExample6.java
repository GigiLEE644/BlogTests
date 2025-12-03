package com.example19;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleExample6 {
    static class Address
            implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
        private String city;

        public Address() {
            System.out.println("\nAddress constructor called");
        }

        public String getCity() {
            System.out.println("\ngetCity called : " + city);
            return city;
        }

        public void setCity(String city) {
            System.out.println("\nsetCity called with: " + city);
            this.city = city;
        }

        @Override
        public void setBeanName(String name) {
            System.out.println("\nBeanNameAware#setBeanName called: " + name);
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            System.out.println("\nBeanFactoryAware#setBeanFactory called: " + beanFactory.getClass());
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println(
                    "\nApplicationContextAware#setApplicationContext called: " + applicationContext.getClass());
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("\nInitializingBean#afterPropertiesSet called for Address");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("\nDisposableBean#destroy called for Address");
        }

        @Override
        public String toString() {
            return "Address{city='" + city + "'}";
        }
    }

    static class User
            implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
        private String name;
        private Address address;

        public User() {
            System.out.println("\nUser constructor called");
        }

        public void setName(String name) {
            System.out.println("\nsetName called with: " + name);
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
            System.out.println("\nsetAddress called with: " + address);
            this.address = address;
        }

        @Override
        public void setBeanName(String name) {
            System.out.println("\nBeanNameAware#setBeanName called: " + name);
        }

        @Override
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            System.out.println("\nBeanFactoryAware#setBeanFactory called: " + beanFactory.getClass());
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            System.out.println(
                    "\nApplicationContextAware#setApplicationContext called: " + applicationContext.getClass());
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("\nInitializingBean#afterPropertiesSet called for User");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("\nDisposableBean#destroy called for User");
        }

        @Override
        public String toString() {
            return "\nUser [name=" + name + ", address=" + address + "]";
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // Register Address bean definition with property injection
        BeanDefinition addressDef = BeanDefinitionBuilder
                .genericBeanDefinition(Address.class)
                .addPropertyValue("city", "New York")
                .getBeanDefinition();
        ctx.registerBeanDefinition("address", addressDef);

        // Register User bean definition with property injection
        BeanDefinition userDef = BeanDefinitionBuilder
                .genericBeanDefinition(User.class)
                .addPropertyValue("name", "Alice")
                .addPropertyReference("address", "address")
                .getBeanDefinition();
        ctx.registerBeanDefinition("user", userDef);

        ctx.addBeanFactoryPostProcessor(
                beanFactory -> beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
                    @Override
                    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
                            throws BeansException {
                        if (beanClass == User.class || beanClass == Address.class) {
                            System.out.println(
                                    "\n1.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: "
                                            + beanName);
                        }
                        return null;
                    }

                    @Override
                    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                        if (bean instanceof Address || bean instanceof User) {
                            System.out.println(
                                    "\n2.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: "
                                            + beanName);
                        }
                        return true;
                    }

                    @Override
                    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
                            throws BeansException {
                        if (bean instanceof Address || bean instanceof User) {
                            System.out.println(
                                    "\n3.InstantiationAwareBeanPostProcessor#postProcessProperties called for: "
                                            + beanName);

                            System.out.println("Current PropertyValues: " + pvs);
                        }
                        return pvs;
                    }
                }));

        ctx.addBeanFactoryPostProcessor(beanFactory -> beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof Address || bean instanceof User) {
                    System.out.println("\n4.BeanPostProcessor#postProcessBeforeInitialization called for: " + beanName);
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof Address || bean instanceof User) {
                    System.out.println("\n5.BeanPostProcessor#postProcessAfterInitialization called for: " + beanName);
                }
                return bean;
            }
        }));

        ctx.refresh();

        User user = ctx.getBean(User.class);

        System.out.println(user);

        ctx.close(); // This will trigger DisposableBean#destroy for beans
    }
}
/*
Output :

        1.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: address
        
        Address constructor called
        
        2.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: address
        
        3.InstantiationAwareBeanPostProcessor#postProcessProperties called for: address
        Current PropertyValues: PropertyValues: length=1; bean property 'city'
        
        setCity called with: New York
        
        BeanNameAware#setBeanName called: address
        
        BeanFactoryAware#setBeanFactory called: class org.springframework.beans.factory.support.DefaultListableBeanFactory
        
        ApplicationContextAware#setApplicationContext called: class org.springframework.context.annotation.AnnotationConfigApplicationContext
        
        4.BeanPostProcessor#postProcessBeforeInitialization called for: address
        
        InitializingBean#afterPropertiesSet called for Address
        
        5.BeanPostProcessor#postProcessAfterInitialization called for: address
        
        1.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: user
        
        User constructor called
        
        2.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: user
        
        3.InstantiationAwareBeanPostProcessor#postProcessProperties called for: user
        Current PropertyValues: PropertyValues: length=2; bean property 'name'; bean property 'address'
        
        setName called with: Alice
        
        setAddress called with: Address{city='New York'}
        
        BeanNameAware#setBeanName called: user
        
        BeanFactoryAware#setBeanFactory called: class org.springframework.beans.factory.support.DefaultListableBeanFactory
        
        ApplicationContextAware#setApplicationContext called: class org.springframework.context.annotation.AnnotationConfigApplicationContext
        
        4.BeanPostProcessor#postProcessBeforeInitialization called for: user
        
        InitializingBean#afterPropertiesSet called for User
        
        5.BeanPostProcessor#postProcessAfterInitialization called for: user
        
        User [name=Alice, address=Address{city='New York'}]
        
        DisposableBean#destroy called for User
        
        DisposableBean#destroy called for Address
*/