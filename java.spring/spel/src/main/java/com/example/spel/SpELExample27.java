package com.example.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample27 {

        public static void main(String[] args) {
                ExpressionParser parser = new SpelExpressionParser();

                StandardEvaluationContext context = new StandardEvaluationContext();
                context.setVariable("name", "john");
                context.setVariable("age", 25);

                Expression expression = parser.parseExpression(
                                "Hello #{#name.toUpperCase()}, you are #{#age} years old!",
                                new TemplateParserContext());

                String result = expression.getValue(context, String.class);

                System.out.println(result);

                System.out.println();

                // Custom Delimiters
                ParserContext customParserContext = new ParserContext() {
                        @Override
                        public String getExpressionPrefix() {
                                return "<<";
                        }

                        @Override
                        public String getExpressionSuffix() {
                                return ">>";
                        }

                        @Override
                        public boolean isTemplate() {
                                return true;
                        }
                };

                expression = parser.parseExpression("Hello <<#name.toUpperCase()>>, you are <<#age>> years old!",
                                customParserContext);

                result = expression.getValue(context, String.class);

                System.out.println(result);
        }
}
/**
 * Output :
 *      Hello JOHN, you are 25 years old!
 *
 *      Hello JOHN, you are 25 years old!
 */