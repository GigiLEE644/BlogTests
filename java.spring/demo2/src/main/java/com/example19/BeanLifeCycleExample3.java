package com.example19;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleExample3 {
    static class Address {
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

        ctx.refresh();

        User user = ctx.getBean(User.class);

        System.out.println(user);

        ctx.close();
    }
}
/*
 * Output:
 * 
 * 1.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: address
 * Address constructor called
 * 2.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: address
 * 3.InstantiationAwareBeanPostProcessor#postProcessProperties called for: address
 * Current PropertyValues: PropertyValues: length=1; bean property 'city'
 * setCity called with: New York
 * 1.InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation called for: user
 * User constructor called
 * 2.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation called for: user
 * 3.InstantiationAwareBeanPostProcessor#postProcessProperties called for: user
 * Current PropertyValues: PropertyValues: length=2; bean property 'name'; bean property 'address'
 * setName called with: Alice
 * setAddress called with: Address{city='New York'}
 * User [name=Alice, address=Address{city='New York'}]
 */