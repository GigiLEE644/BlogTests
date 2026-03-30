package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample29 {

        public static void main(String[] args) {
                int iterations = 1_000_000;

                System.out.println("Running benchmark with " + iterations + " iterations...\n");

                testMode("INTERPRETED (OFF)", SpelCompilerMode.OFF, iterations);
                testMode("IMMEDIATE", SpelCompilerMode.IMMEDIATE, iterations);
                testMode("MIXED", SpelCompilerMode.MIXED, iterations);
        }

        private static void testMode(String label, SpelCompilerMode mode, int iterations) {
                record Person(String name, int age) {
                }

                SpelParserConfiguration config = new SpelParserConfiguration(mode,
                                SpELExample29.class.getClassLoader());

                ExpressionParser parser = new SpelExpressionParser(config);

                // Expression with method call + property access
                Expression exp = parser.parseExpression("name.toUpperCase() + ' - ' + age");

                Person person = new Person("john", 30);
                StandardEvaluationContext context = new StandardEvaluationContext(person);

                // Warm-up (important for MIXED mode to trigger compilation)
                for (int i = 0; i < 10_000; i++) {
                        exp.getValue(context);
                }

                long start = System.nanoTime();

                for (int i = 0; i < iterations; i++) {
                        exp.getValue(context);
                }

                long end = System.nanoTime();

                long durationMs = (end - start) / 1_000_000;

                System.out.println(label + " => " + durationMs + " ms");
        }
}
/**
 * Output (will vary based on machine and JVM optimizations):
        Running benchmark with 1000000 iterations...

        INTERPRETED (OFF) => 1190 ms
        IMMEDIATE => 982 ms
        MIXED => 795 ms
 */