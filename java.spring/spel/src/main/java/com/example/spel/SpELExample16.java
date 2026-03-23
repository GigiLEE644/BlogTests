package com.example.spel;

import java.util.List;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample16 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("numbers", numbers);

        Expression expression = parser.parseExpression("#numbers.?[#this % 2 == 0]");

        System.out.println(expression.getValue(context, List.class));
    }
}
/**
 * Output:
 * [0, 2, 4, 6, 8]
 */