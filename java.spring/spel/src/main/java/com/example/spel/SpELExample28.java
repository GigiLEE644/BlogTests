package com.example.spel;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.Operation;
import org.springframework.expression.OperatorOverloader;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample28 {

        public static void main(String[] args) {
                ExpressionParser parser = new SpelExpressionParser();

                StandardEvaluationContext context = new StandardEvaluationContext();
                context.setOperatorOverloader(new ListConcatenationOverloader());

                List<String> list1 = List.of("A", "B", "C");
                List<String> list2 = List.of("D", "E", "F");

                context.setVariable("list1", list1);
                context.setVariable("list2", list2);

                Expression expression = parser.parseExpression("#list1 + #list2");

                List<?> result = expression.getValue(context, List.class);

                System.out.println(result);
        }

        private static class ListConcatenationOverloader implements OperatorOverloader {

                @Override
                public boolean overridesOperation(Operation operation, @Nullable Object leftOperand,
                                @Nullable Object rightOperand) throws EvaluationException {
                        // We only override ADD (+) for Lists
                        return operation == Operation.ADD
                                        && leftOperand instanceof List
                                        && rightOperand instanceof List;
                }

                @Override
                public Object operate(Operation operation, @Nullable Object leftOperand, @Nullable Object rightOperand)
                                throws EvaluationException {
                        if (operation == Operation.ADD) {
                                List<?> leftList = (List<?>) leftOperand;
                                List<?> rightList = (List<?>) rightOperand;

                                List<Object> result = new ArrayList<>();
                                result.addAll(leftList);
                                result.addAll(rightList);

                                return result;
                        }

                        throw new UnsupportedOperationException("Operation not supported");
                }
        }
}
/**
 * Output :
 *      [A, B, C, D, E, F]
 */