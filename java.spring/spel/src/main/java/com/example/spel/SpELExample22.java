package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample22 {
    public static void main(String[] args) {
        record Address(String city, String country) {
        }

        record Person(String name, int age, Address address) {
        }

        Person tom = new Person("tom", 18, null);

        ExpressionParser parser = new SpelExpressionParser();

        try {
            System.out.println(parser.parseExpression("address.city").getValue(tom, String.class));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        System.out.println(parser.parseExpression("address?.city").getValue(tom, String.class));

        System.out.println();

        // Combining safe navigation operator with Elvis operator
        System.out.println(parser.parseExpression("address?.city ?: 'Unknown'").getValue(tom, String.class));
    }
}
/*
 * Output:
 * Error: EL1007E: Property or field 'city' cannot be found on null
 *
 * null
 *
 * Unknown
 */