package com.example.spel;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample25 {
        public static void main(String[] args) {
                ExpressionParser parser = new SpelExpressionParser();

                StandardEvaluationContext context = new StandardEvaluationContext();
                context.setBeanResolver(new MyBeanResolver());

                System.out.println(parser.parseExpression("@person").getValue(context, Person.class));

                System.out.println();

                System.out.println(parser.parseExpression("@person.greeting()").getValue(context, String.class));
        }

        private static class Person {
                private final String name;
                private final int age;

                public Person(String name, int age) {
                        this.name = name;
                        this.age = age;
                }

                public String greeting() {
                        return "Hello, I'm " + name + " and I'm " + age + " years old.";
                }

                @Override
                public String toString() {
                        return "Person{name='" + name + "', age=" + age + "}";
                }
        }

        private static class MyBeanResolver implements BeanResolver {
                @Override
                public Object resolve(EvaluationContext context, String beanName) throws AccessException {
                        return switch (beanName) {
                                case "person" -> new Person("tom", 18);
                                default -> throw new AccessException("No such bean: " + beanName);
                        };
                }
        }
}
/*
 * Output:
 * Person{name='tom', age=18}
 * 
 * Hello, I'm tom and I'm 18 years old.
 */