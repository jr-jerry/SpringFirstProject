package com.Ducat.SpringFirstProject;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Ducat.SpringFirstProject.Configuration.JwtProperties;

@SpringBootApplication
public class SpringFirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringFirstProjectApplication.class, args);

		
	}

}
