package com.example.spel;

import java.lang.reflect.Method;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample18 {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        StandardEvaluationContext context = new StandardEvaluationContext();

        Method method = SpELExample18.class.getDeclaredMethod("reverse", String.class);

        context.registerFunction("reverse", method);

        SpelExpressionParser parser = new SpelExpressionParser();

        String result = parser.parseExpression("#reverse('hello world')").getValue(context, String.class);

        System.out.println(result);
    }
}
/**
 * Output:
 * dlrow olleh
 */