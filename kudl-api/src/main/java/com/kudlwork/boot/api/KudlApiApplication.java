package com.kudlwork.boot.api;

import com.kudlwork.boot.base.KudlBasePackages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = { KudlApiApplication.class, KudlBasePackages.class })
public class KudlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KudlApiApplication.class, args);
	}
}
