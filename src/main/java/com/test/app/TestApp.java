package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.test.controller", "com.test.service" } )
@EntityScan(basePackages = { "com.test.*" } )
@EnableJpaRepositories("com.test.repo")
public class TestApp
{	
	public static void main(String[] args)
	{
		SpringApplication.run(TestApp.class, args);
	}
}
