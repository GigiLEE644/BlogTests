package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample15 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        Person tom = new Person("tom", 18);

        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("tom", tom);

        Expression expression = parser.parseExpression("#tom.name + ' is ' + #tom.age + ' years old.'");
        System.out.println(expression.getValue(context, String.class));
    }
}
/**
 * Output:
 * tom is 18 years old.
 */