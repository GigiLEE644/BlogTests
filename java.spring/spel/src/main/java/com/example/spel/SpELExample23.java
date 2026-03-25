package com.example.spel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample23 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("numbers", numbers);

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("#numbers.?[#this > 15]").getValue(context, List.class));
        // First Match
        System.out.println(parser.parseExpression("#numbers.^[#this > 15]").getValue(context, Integer.class));
        // Last Match
        System.out.println(parser.parseExpression("#numbers.$[#this > 15]").getValue(context, Integer.class));

        System.out.println();

        record Person(String name, int age) {
        }

        List<Person> people = Arrays.asList(
                new Person("tom", 18),
                new Person("jerry", 16));

        context.setVariable("people", people);

        System.out.println(parser.parseExpression("#people.?[age >= 18]").getValue(context, List.class));
        System.out.println(parser.parseExpression("#people.?[#this.age < 18]").getValue(context, List.class));

        System.out.println();

        Map<String, Integer> scores = Map.of(
                "tom", 60,
                "jerry", 85);

        context.setVariable("scores", scores);

        System.out.println(parser.parseExpression("#scores.?[value >= 80]").getValue(context, Map.class));
    }
}
/*
 * Output:
 * [20, 25, 30]
 * 20
 * 30
 *
 * [Person[name=tom, age=18]]
 * [Person[name=jerry, age=16]]
 *
 * {jerry=85}
 */