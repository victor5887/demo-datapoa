package com.demodatapoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;


@Controller
@SpringBootApplication
public class DemoDatapoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDatapoaApplication.class, args);
		System.out.println("acabou! eh tetraaaaa!!!");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


}