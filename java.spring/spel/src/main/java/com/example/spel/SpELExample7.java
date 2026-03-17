package com.example.spel;

import java.util.Date;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample7 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        @SuppressWarnings("unchecked")
        Class<Date> d = (Class<Date>) parser.parseExpression("T(java.util.Date)").getValue();

        System.out.println(d);

        @SuppressWarnings("unchecked")
        Class<String> s = (Class<String>) parser.parseExpression("T(String)").getValue();

        System.out.println(s);

        Double r = (Double) parser.parseExpression("T(java.lang.Math).random()").getValue();

        System.out.println(r);
    }
}
/**
    Output:
        class java.util.Date
        class java.lang.String
        0.12345678901234567
*/