package com.example.spel;

import java.lang.reflect.Method;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample19 {
    public static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        StandardEvaluationContext context = new StandardEvaluationContext();

        Method method = SpELExample19.class.getDeclaredMethod("sum", int[].class);

        context.registerFunction("sum", method);

        SpelExpressionParser parser = new SpelExpressionParser();

        int total = parser.parseExpression("#sum(1, 2, 3, 4)").getValue(context, Integer.class);

        System.out.println(total);
    }
}
/**
 * Output:
 * 10
 */