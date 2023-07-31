package com.example.server;

import com.example.server.enumeration.Status;
import com.example.server.model.Server;
import com.example.server.repo.ServerRepo;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static com.example.server.enumeration.Status.SERVER_DOWN;
import static com.example.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null,"192.168.160","Ubuntu Linux","16 GB","Personal PC",
							   "http://localhost:8080/server/image/server1.jpg", SERVER_DOWN));

			serverRepo.save(new Server(null,"192.168.58","Fendora Linux","16 GB","Dell Tower",
					"http://localhost:8080/server/image/server2.jpg", SERVER_UP));

			serverRepo.save(new Server(null,"192.168.21","MS 2000","32 GB","Workstation ",
					"http://localhost:8080/server/image/server3.jpg", SERVER_DOWN));

			serverRepo.save(new Server(null,"192.168.16","Red Hat Enterprise Linux","64 GB","Web Server",
					"http://localhost:8080/server/image/server4.jpg", SERVER_UP));
		};
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource UrlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowCredentials(true);

		corsConfiguration.setAllowedOrigins(Arrays.asList("Http://localhost:3000", "http://localhost:4200"));

		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-type","Accept","Jwt-Token",
														  "Authorization","Origin, Accept","X-Requested-With","Access-Control-Requested-Headers"));

		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-type","Accept","Jwt-Token","Authorization","Access-Control-Allow-Origin",
														  "Access-Control-Allow-Credentials","Filename"));

		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));

		UrlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter();
    }


}
