package com.example.spel;

import java.util.Arrays;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample6 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        int[] arr1 = (int[]) parser.parseExpression("new int[4]").getValue();

        System.out.println(arr1.length);

        int[] arr2 = (int[]) parser.parseExpression("new int[] {1, 2, 3}").getValue();

        System.out.println(Arrays.toString(arr2));

        int[][] arr3 = (int[][]) parser.parseExpression("new int[4][5]").getValue();

        System.out.println(arr3.length);
        System.out.println(arr3[0].length);

        // multidimensional array with initializer is not supported yet
        int[][] arr4 = (int[][]) parser.parseExpression("new int[][] {{1, 2}, {3, 4}}").getValue();

        Arrays.stream(arr4).forEach(a -> System.out.println(Arrays.toString(a)));
    }
}
/**
    Output:
        4
        [1, 2, 3]
        4
        5
        Exception in thread "main" org.springframework.expression.spel.SpelEvaluationException: EL1062E: Using an initializer to build a multi-dimensional array is not currently supported
                at org.springframework.expression.spel.ast.ConstructorReference.createArray(ConstructorReference.java:323)
                at org.springframework.expression.spel.ast.ConstructorReference.getValueInternal(ConstructorReference.java:113)
                at org.springframework.expression.spel.ast.SpelNodeImpl.getValue(SpelNodeImpl.java:114)
                at org.springframework.expression.spel.standard.SpelExpression.getValue(SpelExpression.java:140)
                at com.example.spel.SpELExample6.main(SpELExample6.java:25)
*/