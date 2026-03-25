package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample20 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        Person tom = new Person("tom", 18);

        ExpressionParser parser = new SpelExpressionParser();

        String result = parser.parseExpression(
                "age >= 18 ? 'Adult' : 'Minor'").getValue(tom, String.class);

        System.out.println(result);
    }
}
/*
 * Output:
 * Adult
 */