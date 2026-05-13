package com.fing.app.restControllers;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCamel {
	
	
	
	@Produce("direct:startOk")
	private ProducerTemplate template;
	
	@RequestMapping("/camel")
	public String toCamel() {
		
		template.asyncSendBody(template.getDefaultEndpoint(), "Ok");
		
		return "Ok";
	}

}
