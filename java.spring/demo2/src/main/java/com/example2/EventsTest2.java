package com.example2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.*;
import org.springframework.context.support.GenericApplicationContext;

public class EventsTest2 {

    // Listener for all major built-in events using ApplicationListener interface
    public static class AllEventsListener implements ApplicationListener<ApplicationEvent> {
        @Override
        public void onApplicationEvent(ApplicationEvent event) {
            if (event instanceof ContextRefreshedEvent) {
                System.out.println("\nContextRefreshedEvent received");
            } else if (event instanceof ContextStartedEvent) {
                System.out.println("\nContextStartedEvent received");
            } else if (event instanceof ContextStoppedEvent) {
                System.out.println("\nContextStoppedEvent received");
            } else if (event instanceof ContextClosedEvent) {
                System.out.println("\nContextClosedEvent received");
            } else if (event instanceof MyCustomEvent) {
                System.out.println("\nMyCustomEvent received: " + ((MyCustomEvent) event).getMessage());
            } else {
                System.out.println("\nOther ApplicationEvent received: " + event.getClass().getSimpleName());
            }
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

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(AllEventsListener.class);

        context.refresh();

        // Publish a custom event
        context.publishEvent(new MyCustomEvent(context, "Hello from custom event!"));

        // Trigger other events
        context.start();
        context.stop();
        context.close();
    }
}
