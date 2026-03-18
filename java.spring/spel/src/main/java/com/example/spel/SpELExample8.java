package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample8 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        Person tom = new Person("tom", 18);

        ExpressionParser parser = new SpelExpressionParser();

        String name = parser.parseExpression("name").getValue(tom, String.class);
        int age = parser.parseExpression("age").getValue(tom, Integer.class);

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        System.out.println();

        StandardEvaluationContext context = new StandardEvaluationContext(tom);

        String name2 = parser.parseExpression("name").getValue(context, String.class);
        int age2 = parser.parseExpression("age").getValue(context, Integer.class);

        System.out.println("Name: " + name2);
        System.out.println("Age: " + age2);

        System.out.println();

        StandardEvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("tom", tom);

        String name3 = parser.parseExpression("#tom.name").getValue(context2, String.class);
        int age3 = parser.parseExpression("#tom.age").getValue(context2, Integer.class);

        System.out.println("Name: " + name3);
        System.out.println("Age: " + age3);
    }
}
/**
    Output:
        Name: tom
        Age: 18

        Name: tom
        Age: 18

        Name: tom
        Age: 18
*/