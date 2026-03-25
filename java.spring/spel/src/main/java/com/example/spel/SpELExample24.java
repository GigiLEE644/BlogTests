package com.example.spel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample24 {
    public static void main(String[] args) {
        record Person(String name, int age) {
        }

        List<Person> people = Arrays.asList(
                new Person("tom", 18),
                new Person("jerry", 16));

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("people", people);

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("#people.![name]").getValue(context, List.class));
        System.out.println(parser.parseExpression("#people.![#this.name]").getValue(context, List.class));

        System.out.println();

        System.out.println(parser.parseExpression("#people.![age + 10]").getValue(context, List.class));

        System.out.println();

        System.out.println(parser.parseExpression("#people.![name.toUpperCase()]").getValue(context, List.class));

        System.out.println();

        Map<String, Integer> scores = Map.of(
                "tom", 60,
                "jerry", 85);

        context.setVariable("scores", scores);

        System.out.println(parser.parseExpression("#scores.![key + \":\" + value]").getValue(context, List.class));

        System.out.println();

        // Selection Combining with Projection
        System.out.println(parser.parseExpression("#people.?[age >= 18].![name]").getValue(context, List.class));

        System.out.println();

        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6));

        context.setVariable("matrix", matrix);

        // Nested Projection
        System.out.println(parser.parseExpression("#matrix.![#this.![#this * 2]]").getValue(context, List.class));
    }
}
/*
 * Output:
 * [tom, jerry]
 * [tom, jerry]
 *
 * [28, 26]
 *
 * [TOM, JERRY]
 *
 * [tom:60, jerry:85]
 *
 * [tom]
 *
 * [[2, 4, 6], [8, 10, 12]]
 */