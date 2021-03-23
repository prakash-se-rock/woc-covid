package com.woc.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class WOCCovidApplication {

	public static void main(String[] args) {
		SpringApplication.run(WOCCovidApplication.class, args);
	}

}
