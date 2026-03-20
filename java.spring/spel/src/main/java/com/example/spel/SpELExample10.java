package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample10 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        String className = Person.class.getName();

        Expression expression = parser.parseExpression("new " + className + "('tom', 18)");

        Person tom = expression.getValue(Person.class);

        System.out.println(tom);

        System.out.println();

        StandardEvaluationContext context = new StandardEvaluationContext();
        var constructor = Person.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        context.setVariable("personCtor", constructor);

        expression = parser.parseExpression("#personCtor.newInstance('tom', 18)");

        tom = (Person) expression.getValue(context);

        System.out.println(tom);
    }

    public record Person(String name, int age) {
    }
}
/**
    Output:
        Person[name=tom, age=18]

        Person[name=tom, age=18]
 */