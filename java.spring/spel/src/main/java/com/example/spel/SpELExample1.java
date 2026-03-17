package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample1 {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("greeting", "Hello World from SpEL");

        Expression exp = parser.parseExpression("#greeting");

        String value = exp.getValue(context, String.class);

        System.out.println(value);
    }
}
/**
    Output:
        Hello World from SpEL
*/