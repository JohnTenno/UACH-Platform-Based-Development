package com.fing.app.rutas;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.ProcessorEndpoint;
import org.springframework.stereotype.Component;

import com.fing.app.MyBean;


@Component
public class Conf extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	
    	
    	//from("direct:start")
        //.to("bean:com.example.MyBean?method=processMessage") // Invoke specific method
        //.to("log:processedMessage");

	    //from("direct:log")
	    //    .bean(new MyBean(), "logMessage") // Using the bean() method with an instance and method name
	    //    .to("log:loggedMessage");
	    	
    	
    	//from("direct:hello")
    	//   .to("bean:com.fing.app.MyBean").log("--> ${body}");
    	
    	//from("timer:bar?period=10s").to("log:bar");
    	
    	
    	from("direct:startOk")
    		.log("Message from Rest: ${body}");
    	
    	
    	/*
    	from("timer:myTimer?period=3000")
        .setBody(simple("Hello Camel from timer"))
        .process(exchange -> {
            System.out.println("=== Properties ===");
            exchange.getProperties().forEach((k, v) -> 
                System.out.println(k + " = " + v));
            System.out.println("=== Headers ===");
            exchange.getIn().getHeaders().forEach((k, v) -> 
                System.out.println(k + " = " + v));
        })
        .log("Message: ${body}");
    	
    	*/
    	
    	
    	/*
    	 
    	from("timer:myTimer?period=3000")
        .setBody(simple("Hello Camel from timer at ${date:now:yyyy-MM-dd HH:mm:ss}"))
        .log("Timer triggered: ${body}")
        .to("log:com.miempresa.miruta?level=INFO&showBody=true");
    	
    	*/
    	
    	
    	/*
    	from("timer:myTimer?period=3000") // Triggers every 5 seconds
        .setBody(simple("Hello Camel from timer at ${header.firedTime}")) // Sets the message body
        .process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				
				Object o = exchange.getIn();
				System.out.println(exchange);
				
			}
		})
    	//.setBody( e -> new Date())
        .to("log:${body}");
        //.log(LoggingLevel.INFO, "__Error__")
        //.log("${body}"); // Logs the message to console
    	
    	*/
    	
    	//from("timer:myTimer?period=3000")
        //.setBody(simple("Hello Camel from timer at ${header.firedTime}"))
        //.log("Timer triggered: ${body}")
        //.to("log:com.miempresa.miruta?level=INFO&showBody=true");
        
    }
}