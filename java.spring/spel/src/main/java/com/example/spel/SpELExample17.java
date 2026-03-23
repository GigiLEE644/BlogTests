package com.example.spel;

import java.util.List;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample17 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        List<Person> people = List.of(
                new Person("tom", 18),
                new Person("jerry", 16));

        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("#root.?[#this.age > 17]");

        System.out.println(expression.getValue(people, List.class));

        System.out.println();

        StandardEvaluationContext context = new StandardEvaluationContext(people);

        expression = parser.parseExpression("#root.?[#this.age < 17]");

        System.out.println(expression.getValue(context, List.class));
    }
}
/**
 * Output:
 * [Person[name=tom, age=18]]
 *
 * [Person[name=jerry, age=16]]
 */