package com.literalura.apilibros;

import com.literalura.apilibros.menu.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApilibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApilibrosApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(Menu menu) {
		return args -> menu.displayMenu();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
