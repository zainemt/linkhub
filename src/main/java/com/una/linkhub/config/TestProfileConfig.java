package com.una.linkhub.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.una.linkhub.model.User;
import com.una.linkhub.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {
	
	private static int defaultRoomQuantity = 3;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User user1 = new User(null, "zaine", "zaine@gmail", "zaine1", "123", defaultRoomQuantity);
		User user2 = new User(null, "laysa", "laysa@gmail", "laysa1", "123", defaultRoomQuantity);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}

}
