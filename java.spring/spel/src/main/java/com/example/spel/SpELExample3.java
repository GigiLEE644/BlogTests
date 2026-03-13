package com.example.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample3 {
    private static final ExpressionParser parser = new SpelExpressionParser();

    public static void main(String[] args) {
        print("10 > 5");
        print("10 < 5");
        print("10 >= 5");
        print("10 <= 5");
        print("10 == 10");
        print("5 != 5");

        System.out.println();

        print("1 between {1, 5}");
        print("1 between {10, 15}");
        print("'elephant' between {'aardvark', 'zebra'}");
        print("'elephant' between {'aardvark', 'cobra'}");
        print("123 instanceof T(Integer)");
        print("'xyz' instanceof T(Integer)");
        print("'5.00' matches '^-?\\d+(\\.\\d{2})?$'");
        print("'5.0067' matches '^-?\\d+(\\.\\d{2})?$'");

        System.out.println();

        print("true and false");
        print("true or false");
        print("not false");
        print("true && false");
        print("true || false");
        print("!false");

        System.out.println();

        print("10 + 5");
        print("20 - 5");
        print("10 * 5");
        print("7 % 4");
        print("2 ^ 31");

        System.out.println();

        print("'hello' + ' ' + 'world'");
        print("'d' - 3");
        print("'abc' * 2");
    }

    private static void print(String expression) {
        Object value = parser.parseExpression(expression).getValue();
        System.out.println(expression + " : " + value);
    }
}
/**
 * Output:
        10 > 5 : true
        10 < 5 : false
        10 >= 5 : true
        10 <= 5 : false
        10 == 10 : true
        5 != 5 : false
        
        1 between {1, 5} : true
        1 between {10, 15} : false
        'elephant' between {'aardvark', 'zebra'} : true
        'elephant' between {'aardvark', 'cobra'} : false
        123 instanceof T(Integer) : true
        'xyz' instanceof T(Integer) : false
        '5.00' matches '^-?\d+(\.\d{2})?$' : true
        '5.0067' matches '^-?\d+(\.\d{2})?$' : false
        
        true and false : false
        true or false : true
        not false : true
        true && false : false
        true || false : true
        !false : true
        
        10 + 5 : 15
        20 - 5 : 15
        10 * 5 : 50
        7 % 4 : 3
        2 ^ 31 : 2147483648
        
        'hello' + ' ' + 'world' : hello world
        'd' - 3 : a
        'abc' * 2 : abcabc
 */