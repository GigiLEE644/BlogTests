package com.example.spel;

import java.util.Map;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELExample5 {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        @SuppressWarnings("unchecked")
        Map<String, Object> m1 = (Map<String, Object>) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue();

        m1.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println();

        @SuppressWarnings("unchecked")
        Map<String, Object> m2 = (Map<String, Object>) parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}").getValue();

        m2.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
/**
 * Output:
 * name : Nikola
 * dob : 10-July-1856
 *
 * name : {first=Nikola, last=Tesla}
 * dob : {day=10, month=July, year=1856}
 */