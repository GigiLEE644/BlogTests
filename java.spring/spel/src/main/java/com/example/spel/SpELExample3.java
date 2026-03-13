package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample3 {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("10 > 5").getValue());
        System.out.println(parser.parseExpression("10 < 5").getValue());
        System.out.println(parser.parseExpression("10 >= 5").getValue());
        System.out.println(parser.parseExpression("10 <= 5").getValue());
        System.out.println(parser.parseExpression("10 == 10").getValue());
        System.out.println(parser.parseExpression("5 != 5").getValue());
        System.out.println(parser.parseExpression("true and false").getValue());
        System.out.println(parser.parseExpression("true or false").getValue());
        System.out.println(parser.parseExpression("not false").getValue());
    }
}
/**
 * Output:
 * true
 * false
 * true
 * false
 * true
 * false
 * false
 * true
 * true
 */