package com.fing.app.conf;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		// Example: Set a value in Redis
        from("direct:setRedis")
            .setHeader("CamelRedis.Key", constant("myKey"))
            .setHeader("CamelRedis.Value", body())
            .to("spring-redis://localhost:6379?command=SET")
            .log("Set key myKey to: ${body}");

        // Example: Get a value from Redis
        from("direct:getRedis")
            .setHeader("CamelRedis.Key", constant("myKey"))
            .to("spring-redis://localhost:6379?command=GET")
            .log("Retrieved from Redis: ${body}");
		
		
		/*
         * Ruta productora:
         * Recibe mensajes desde direct:sendToRabbit
         * y los publica en RabbitMQ.
         */
        from("direct:sendToRabbit")
            .routeId("camel-rabbitmq-producer-route")
            .log("Camel enviando mensaje a RabbitMQ: ${body}")
            .to("spring-rabbitmq:" + RabbitMQConfig.EXCHANGE_NAME
                + "?routingKey=fing.isc"
                + "&exchangeType=topic")
            .log("Mensaje enviado correctamente por Camel");

        /*
         * Ruta consumidora:
         * Lee mensajes desde myQueue, asociada a myExchange.
         */
        from("spring-rabbitmq:" + RabbitMQConfig.EXCHANGE_NAME
                + "?queues=" + RabbitMQConfig.QUEUE_NAME
                + "&routingKey=routing.key.#"
                + "&exchangeType=topic"
                + "&autoDeclare=false")
            .routeId("camel-rabbitmq-consumer-route")
            .log("Camel recibió desde RabbitMQ: ${body}")
            .process(exchange -> {
                String mensaje = exchange.getMessage().getBody(String.class);
                System.out.println("Mensaje procesado por ruta Camel: " + mensaje.toUpperCase());
            });
		
	}

}
