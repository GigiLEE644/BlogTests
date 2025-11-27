package com.example19;

public class BeanLifeCycleExample {
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

    public static void main(String[] args) {
        Address address = new Address("New York");
        User user = new User("Alice", address);

        System.out.println(user);
    }
}
/*
Output:
    Address constructor with city called: New York
    
    User constructor with name and address called: Alice, Address{city='New York'}
    
    User [name=Alice, address=Address{city='New York'}]
*/