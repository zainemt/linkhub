package com.una.linkhub.config;

import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class DotenvConfig {
	
	private static final Dotenv dotenv = Dotenv.configure().load();

	 public static String get(String key) {
	        return dotenv.get(key);
	 }
}
