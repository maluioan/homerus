package com.test.jpa;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainBoot {

	static final Logger logger = LogManager.getLogger(MainBoot.class.getName());

	public static void main(String[] args) {
		logger.info("running my first spring boot application");
		ApplicationContext ctx = SpringApplication.run(MainBoot.class, args);

		System.out.println("*************************************************" + ctx.getDisplayName());
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

	}
}
