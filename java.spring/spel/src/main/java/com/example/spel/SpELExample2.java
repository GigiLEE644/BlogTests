package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample2 {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("'Hello World'").getValue());
        System.out.println(parser.parseExpression("'Tony''s Pizza'").getValue());
        System.out.println(parser.parseExpression("6.0221415E+23").getValue());
        System.out.println(parser.parseExpression("0x7FFFFFFF").getValue());
        System.out.println(parser.parseExpression("true").getValue());
        System.out.println(parser.parseExpression("null").getValue());
    }
}
/**
 * Output:
 * Hello World
 * Tony's Pizza
 * 6.0221415E+23
 * 2147483647
 * true
 * null
 */