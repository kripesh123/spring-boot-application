package com.kripesh.cms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CmsApplication {

	private static final Logger log = LoggerFactory.getLogger(CmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

		};
	}





}
