package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample12 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        String greeting = "hello world";

        for (int i = 0; i < greeting.length(); i++) {
            Expression expression = parser.parseExpression("'" + greeting + "'[" + i + "]");

            String result = expression.getValue(String.class);

            System.out.print(result);
        }

        System.out.println();
    }
}
/**
 * Output:
 * hello world
 */