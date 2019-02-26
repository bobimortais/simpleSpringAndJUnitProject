package com.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.test.controller", "com.test.service"} )
public class TestApp
{	
	public static void main(String[] args)
	{
		SpringApplication.run(TestApp.class, args);
	}
}
