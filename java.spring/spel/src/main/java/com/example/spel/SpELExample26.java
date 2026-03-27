package com.example.spel;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpELExample26 {
        public static void main(String[] args) throws Exception {
                ExpressionParser parser = new SpelExpressionParser();

                StandardEvaluationContext context = new StandardEvaluationContext();
                context.setBeanResolver(new MyBeanResolver());

                MyFactoryBean factory = parser.parseExpression("&myFactoryBean").getValue(context, MyFactoryBean.class);

                System.out.println(factory.getObject());
        }

        private static class MyFactoryBean implements FactoryBean<String> {
                @Override
                public @Nullable String getObject() throws Exception {
                        return "Hello World from MyFactoryBean";
                }

                @Override
                public @Nullable Class<String> getObjectType() {
                        return String.class;
                }

        }

        private static class MyBeanResolver implements BeanResolver {
                @Override
                public Object resolve(EvaluationContext context, String beanName) throws AccessException {
                        return switch (beanName) {
                                case "&myFactoryBean" -> new MyFactoryBean();
                                default -> throw new AccessException("No such bean: " + beanName);
                        };
                }
        }
}
/**
 * Output :
 *      Hello World from MyFactoryBean
 */