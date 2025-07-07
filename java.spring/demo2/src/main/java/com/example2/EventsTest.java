package com.example2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.Lifecycle;
import org.springframework.context.event.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

public class EventsTest {

    // Listener using @EventListener annotation for various built-in events
    @Component
    public static class AllEventsListener {

        @EventListener
        public void onContextRefreshed(ContextRefreshedEvent event) {
            System.out.println("\nContextRefreshedEvent received");
        }

        @EventListener
        public void onContextStarted(ContextStartedEvent event) {
            System.out.println("\nContextStartedEvent received");
        }

        @EventListener
        public void onContextStopped(ContextStoppedEvent event) {
            System.out.println("\nContextStoppedEvent received");
        }

        @EventListener
        public void onContextClosed(ContextClosedEvent event) {
            System.out.println("\nContextClosedEvent received");
        }

        @EventListener
        public void onGenericEvent(ApplicationEvent event) {
            System.out.println("\nGeneric ApplicationEvent received: " + event.getClass().getSimpleName());
        }

        // Custom event
        @EventListener
        public void onCustomEvent(MyCustomEvent event) {
            System.out.println("\nMyCustomEvent received: " + event.getMessage());
        }
    }

    // Custom event class
    public static class MyCustomEvent extends ApplicationEvent {
        private final String message;

        public MyCustomEvent(Object source, String message) {
            super(source);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    // Example of a bean with start/stop logic
    public static class MyLifecycleBean implements Lifecycle {
        private boolean running = false;

        @Override
        public void start() {
            running = true;
            System.out.println("\nMyLifecycleBean started!");
        }

        @Override
        public void stop() {
            running = false;
            System.out.println("\nMyLifecycleBean stopped!");
        }

        @Override
        public boolean isRunning() {
            return running;
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(AllEventsListener.class);
        context.registerBean(org.springframework.context.event.EventListenerMethodProcessor.class);
        context.registerBean(org.springframework.context.event.DefaultEventListenerFactory.class);

        // Register the lifecycle bean
        context.registerBean(MyLifecycleBean.class);

        context.refresh();

        context.publishEvent(new MyCustomEvent(context, "Hello from custom event!"));
        context.start(); // Will trigger start() on MyLifecycleBean and ContextStartedEvent
        context.stop();  // Will trigger stop() on MyLifecycleBean and ContextStoppedEvent
        context.close(); // Will trigger ContextClosedEvent
    }
}
