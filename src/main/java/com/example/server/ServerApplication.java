package com.example.server;

import com.example.server.enumeration.Status;
import com.example.server.model.Server;
import com.example.server.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
