package com.example19;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleExample3 {
    static class Address {
        private String city;

        public Address() {
            System.out.println("\nAddress constructor called");
        }

        public Address(String city) {
            this.city = city;
            System.out.println("\nAddress constructor with city called: " + city);
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
        public String toString() {
            return "Address{city='" + city + "'}";
        }
    }

    static class User {
        private String name;
        private Address address;

        public User() {
            System.out.println("\nUser constructor called");
        }

        public User(String name, Address address) {
            this.name = name;
            this.address = address;
            System.out.println("\nUser constructor with name and address called: " + name + ", " + address);
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
        public String toString() {
            return "\nUser [name=" + name + ", address=" + address + "]";
        }
    }

    @Configuration
    static class Configs {
        @Bean
        public Address address() {
            return new Address("New York");
        }

        @Bean
        public User user(Address address) {
            return new User("Alice", address);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.addBeanFactoryPostProcessor(
                beanFactory -> beanFactory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
                    @Override
                    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
                            throws BeansException {
                        if (beanClass == User.class || beanClass == Address.class) {
                            System.out.println(
                                    "\nInstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: "
                                            + beanName);
                        }

                        return null;
                    }

                    @Override
                    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                        if (bean instanceof Address || bean instanceof User) {
                            System.out.println(
                                    "\nInstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: "
                                            + beanName);
                        }

                        return true;
                    }

                    @Override
                    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
                            throws BeansException {
                        if (bean instanceof Address || bean instanceof User) {
                            System.out.println(
                                    "\nInstantiationAwareBeanPostProcessor#postProcessProperties called for: "
                                            + beanName);

                            System.out.println("Current PropertyValues: " + pvs);
                        }

                        return pvs;
                    }
                }));

        ctx.register(Configs.class);

        ctx.refresh();

        User user = ctx.getBean(User.class);

        System.out.println(user);

        ctx.close();
    }
}
