package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample1 {

    public static void main(String[] args) {

        ExpressionParser parser = new SpelExpressionParser();

        Expression exp = parser.parseExpression("'Hello World from SpEL'");

        String value = exp.getValue(String.class);

        System.out.println(value);
    }
}
/**
 * Output:
 * Hello World from SpEL
 */