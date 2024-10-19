package com.una.linkhub.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.una.linkhub.model.Link;
import com.una.linkhub.model.User;
import com.una.linkhub.repositories.LinkRepository;
import com.una.linkhub.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {
	
	private static int defaultRoomQuantity = 3;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User user1 = new User(null, "zaine", "zaine@gmail", "zaine1", "123", defaultRoomQuantity);
		User user2 = new User(null, "laysa", "laysa@gmail", "laysa1", "123", defaultRoomQuantity);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Link link1 = new Link(null, "aaaaaaaa", user1);
		Link link2 = new Link(null, "bbbbbbbb", user2);
		
		linkRepository.saveAll(Arrays.asList(link1, link2));
		
		user1.getLinks().add(link2);
		user2.getLinks().add(link1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		

		
	}

}
