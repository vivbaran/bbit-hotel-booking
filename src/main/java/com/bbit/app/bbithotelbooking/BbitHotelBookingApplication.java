package com.bbit.app.bbithotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@ComponentScan("com.bbit.app.bbithotelbooking.*")
@SpringBootApplication
public class BbitHotelBookingApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(BbitHotelBookingApplication.class, args);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/static/","classpath:/img/")
        .setCachePeriod(0);
    }

}
