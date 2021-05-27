package com.flicklist;
import com.flicklist.service.tmdb.TmdbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@Slf4j
public class FlicklistApplication {

	@Bean
	public TmdbService getTmdbService(){
		return new TmdbService("https://api.themoviedb.org/3");
	}

	public static void main(String[] args) {
		log.info("launching app");
		SpringApplication.run(FlicklistApplication.class, args);
	}

}
