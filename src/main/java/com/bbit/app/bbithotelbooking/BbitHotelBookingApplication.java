package com.bbit.app.bbithotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.bbit.app.*")
@SpringBootApplication
public class BbitHotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbitHotelBookingApplication.class, args);
	}

}
