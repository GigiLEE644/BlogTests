package com.example.spel;

import java.util.List;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample4 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        @SuppressWarnings("unchecked")
        List<Integer> numbers = (List<Integer>) parser.parseExpression("{1,2,3,4}").getValue();

        numbers.forEach(System.out::print);

        System.out.println();

        @SuppressWarnings("unchecked")
        List<List<String>> listOfLists = (List<List<String>>) parser.parseExpression("{{'a','b'},{'x','y'}}")
                .getValue();

        listOfLists.forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}
/**
 * Output:
 * 1234
 * ab
 * xy
 */