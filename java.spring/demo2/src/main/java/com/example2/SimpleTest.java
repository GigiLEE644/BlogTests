package com.example2;

public class SimpleTest {
    private static class A {
        public A() {
            new B();
            System.out.println("A constructor called");
        }
    }

    private static class B {
        public B() {
            new A(); // Creating an instance of A within B's constructor
            System.out.println("B constructor called");
        }
    }

    public static void main(String[] args) {
        new A();
    }
}
