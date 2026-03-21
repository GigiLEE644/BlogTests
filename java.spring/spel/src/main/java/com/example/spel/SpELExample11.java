package com.example.spel;

import java.util.List;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample11 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        int[] arr = { 1, 2, 3 };

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("arr", arr);

        Expression expression = parser.parseExpression("#arr[0] + #arr[1] + #arr[2]");

        int result = expression.getValue(context, Integer.class);

        System.out.println(result);

        System.out.println();

        List<Integer> list = List.of(1, 2, 3);
        context.setVariable("list", list);

        expression = parser.parseExpression("#list[0] + #list[1] + #list[2]");

        result = expression.getValue(context, Integer.class);

        System.out.println(result);
    }
}
/**
 * Output:
 * 6
 * 6
 */