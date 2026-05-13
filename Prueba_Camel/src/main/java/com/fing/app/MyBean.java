package com.fing.app;

public class MyBean {

    public String saySomething(String input) {
        return "Hello " + input;
    }
    
    public String processMessage(String input) {
        System.out.println("Processing message in MyBean: " + input);
        return "Processed: " + input.toUpperCase();
    }

    public void logMessage(String message) {
        System.out.println("Logging message from MyBean: " + message);
    }
}
