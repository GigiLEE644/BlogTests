package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample21 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        ExpressionParser parser = new SpelExpressionParser();

        String result = parser.parseExpression("name ?: 'Anonymous'").getValue(new Person(null, 18), String.class);

        System.out.println(result);

        System.out.println();

        System.out.println(parser.parseExpression("name ?: 'Anonymous'").getValue(new Person("tom", 18), String.class));

        System.out.println();

        System.out.println(parser.parseExpression("name != null ? name : 'Anonymous'").getValue(new Person(null, 18),
                String.class));

        System.out.println();

        System.out.println(parser.parseExpression("name != null ? name : 'Anonymous'").getValue(new Person("tom", 18),
                String.class));
    }
}
/*
 * Output:
 * Anonymous
 *
 * tom
 *
 * Anonymous
 *
 * tom
 */