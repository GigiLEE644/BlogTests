package com.example.spel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample31 {
        public static void main(String[] args) throws IOException, InterruptedException {
                String input = "T(java.lang.Runtime).getRuntime().exec('date')";

                // unsafe: allows access to all classes and methods
                run(new StandardEvaluationContext(), input);

                System.out.println();

                // safe: only allows access to properties and methods of the root object
                run(SimpleEvaluationContext.forReadOnlyDataBinding().build(), input);
        }

        private static void run(EvaluationContext context, String input) throws IOException, InterruptedException {
                ExpressionParser parser = new SpelExpressionParser();

                Expression expression = parser.parseExpression(input);

                Process process = (Process) expression.getValue(context);

                displayExecutionOutput(process);

                process.waitFor();
        }

        private static void displayExecutionOutput(Process process) throws IOException {
                BufferedReader reader = new BufferedReader(
                                new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                        System.out.println("OUTPUT: " + line);
                }

                BufferedReader errorReader = new BufferedReader(
                                new InputStreamReader(process.getErrorStream()));

                while ((line = errorReader.readLine()) != null) {
                        System.err.println("ERROR: " + line);
                }
        }
}
/**
 * Output:
 
        OUTPUT: Sat Apr  4 05:40:17 PM CEST 2026

        Exception in thread "main" org.springframework.expression.spel.SpelEvaluationException: EL1005E: Type cannot be found 'java.lang.Runtime'
                at org.springframework.expression.spel.support.SimpleEvaluationContext.lambda$static$0(SimpleEvaluationContext.java:105)
                at org.springframework.expression.spel.ExpressionState.findType(ExpressionState.java:176)
                at org.springframework.expression.spel.ast.TypeReference.getValueInternal(TypeReference.java:71)
                at org.springframework.expression.spel.ast.CompoundExpression.getValueRef(CompoundExpression.java:60)
                at org.springframework.expression.spel.ast.CompoundExpression.getValueInternal(CompoundExpression.java:96)
                at org.springframework.expression.spel.ast.SpelNodeImpl.getValue(SpelNodeImpl.java:114)
                at org.springframework.expression.spel.standard.SpelExpression.getValue(SpelExpression.java:267)
                at com.example.spel.SpELExample31.run(SpELExample31.java:32)
                at com.example.spel.SpELExample31.main(SpELExample31.java:24)
 */