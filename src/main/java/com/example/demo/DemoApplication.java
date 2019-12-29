package com.example.demo;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/hello")
	public String hello(){
		return "hello spring";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public ServletWebServerFactory serverFactory(){
		TomcatServletWebServerFactory tomcatServletWebServerFactory  = new TomcatServletWebServerFactory();
		tomcatServletWebServerFactory.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcatServletWebServerFactory;
	}

	private Connector createStandardConnector(){
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setPort(8080);
		return connector;
	}
}
