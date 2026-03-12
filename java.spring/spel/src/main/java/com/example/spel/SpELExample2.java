package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample2 {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("10 + 5").getValue());
        System.out.println(parser.parseExpression("20 - 5").getValue());
        System.out.println(parser.parseExpression("10 * 5").getValue());
        System.out.println(parser.parseExpression("20 / 4").getValue());
    }
}
/**
 * Output:
 * 15
 * 15
 * 50
 * 5
 */