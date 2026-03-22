package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample14 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        Person tom = new Person("tom", 18);

        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("tom", tom);

        Expression expression = parser.parseExpression("#tom['name']");
        String name = expression.getValue(context, String.class);
        System.out.println(name);

        expression = parser.parseExpression("#tom['age']");
        int age = expression.getValue(context, Integer.class);
        System.out.println(age);
    }
}
/**
 * Output:
 * tom
 * 18
 */