package com.example2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            HelloWorld hw = (HelloWorld) ctx.getBean("com.example2.Application$HelloWorld");
            hw.greeting();
        };
    }

    @Component
    class HelloWorld {
        @LogExecutionTime(additionalMessage = "To say helloworld after 1 second")
        public void greeting() throws InterruptedException {
            Thread.sleep(1000);
            System.out.println("Hello World");
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface LogExecutionTime {
        String additionalMessage() default "";
    }

    @Component
    @Aspect
    class LogAspect {
        private final Logger log = LoggerFactory.getLogger(this.getClass());

        @Around("@annotation(com.example2.Application$LogExecutionTime)")
        public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            String className = methodSignature.getDeclaringType().getSimpleName();
            String methodName = methodSignature.getMethod().getName();
            Instant startTime = Instant.now();
            Object result = proceedingJoinPoint.proceed();
            String additionalMessage = methodSignature.getMethod().getAnnotation(LogExecutionTime.class)
                    .additionalMessage();
            long elapsedTime = Duration.between(startTime, Instant.now()).toMillis();
            log.info("Class Name: {}, Method Name: {}, Additional Message: {}, Elapsed Time: {}ms",
                    className, methodName, additionalMessage, elapsedTime);
            return result;
        }
    }
}