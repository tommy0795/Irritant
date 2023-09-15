package org.edf.cat.mmesi.Irritant;

import org.edf.cat.mmesi.Irritant.auth.RegisterRequest;
import org.edf.cat.mmesi.Irritant.auth.AuthService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.edf.cat.mmesi.Irritant.model.Role.*;

@SpringBootApplication
public class IrritantApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrritantApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AuthService service) {

		return args -> {
			var admin = RegisterRequest.builder().firstName("admin").lastName("admin").nni("00000").role(ADMIN).build();
		//	System.out.println("admin token: " +service.register(admin).getAccessToken());

			/**
			var manager = RegisterRequest.builder().firstName("").lastName("").nni("").role(MANAGER).build();
			System.out.println("manager token:" + service.register(manager).getAccessToken());

			var user = RegisterRequest.builder().firstName("").lastName("").nni("").role(USER).build();
			System.out.println("user token" + service.register(user).getAccessToken());
			 */

		};
	}
}
