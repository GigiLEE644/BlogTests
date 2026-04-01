package com.example.spel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample30 {
        public static void main(String[] args) {
                ExpressionParser parser = new SpelExpressionParser();

                String expression = "age > 18";

                List<User> users = generateUsers(1_000_000);

                bad(parser, users, expression);

                System.out.println();

                good(parser, users, expression);
        }

        private static void good(ExpressionParser parser, List<User> users, String expression) {
                // ✅ parse once
                Expression exp = parser.parseExpression(expression);

                long start = System.currentTimeMillis();

                int count = 0;

                StandardEvaluationContext context = new StandardEvaluationContext();

                for (User user : users) {
                        context.setRootObject(user);

                        Boolean result = exp.getValue(context, Boolean.class);

                        if (result) {
                                count++;
                        }
                }

                long end = System.currentTimeMillis();

                System.out.println("Adults: " + count);
                System.out.println("Time (good): " + (end - start) + " ms");
        }

        private static void bad(ExpressionParser parser, List<User> users, String expression) {
                long start = System.currentTimeMillis();

                int count = 0;

                StandardEvaluationContext context = new StandardEvaluationContext();

                for (User user : users) {
                        // ❌ parsing every iteration
                        Expression exp = parser.parseExpression(expression);

                        context.setRootObject(user);

                        Boolean result = exp.getValue(context, Boolean.class);

                        if (result) {
                                count++;
                        }
                }

                long end = System.currentTimeMillis();

                System.out.println("Adults: " + count);
                System.out.println("Time (bad): " + (end - start) + " ms");
        }

        private record User(int age) {
        }

        private static List<User> generateUsers(int size) {
                List<User> list = new ArrayList<>();
                Random random = new Random();
                for (int i = 0; i < size; i++) {
                        list.add(new User(random.nextInt(100)));
                }
                return list;
        }
}
/**
 * Output (will vary based on machine and JVM optimizations):
 * Adults: 810142
 * Time (bad): 1889 ms
 * 
 * Adults: 810142
 * Time (good): 414 ms
 */