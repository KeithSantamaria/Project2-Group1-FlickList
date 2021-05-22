package com.flicklist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class FlicklistApplication {


	@Bean
	public WebClient getWebClient(){
		return WebClient.create("https://api.themoviedb.org/3");
	}

	public static void main(String[] args) {
		SpringApplication.run(FlicklistApplication.class, args);
	}

}
