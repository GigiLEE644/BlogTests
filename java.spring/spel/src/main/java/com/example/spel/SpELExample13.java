package com.example.spel;

import java.util.Map;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample13 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        Map<String, Integer> m = Map.of("a", 1, "b", 2, "c", 3);

        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("m", m);

        m.keySet().forEach(key -> {
            Expression expression = parser.parseExpression("#m['" + key + "']");

            Integer value = expression.getValue(context, Integer.class);

            System.out.println(key + " : " + value);
        });
    }
}
/**
 * Output:
 * a : 1
 * b : 2
 * c : 3
 */