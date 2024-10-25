package com.una.linkhub.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.una.linkhub.model.Link;
import com.una.linkhub.model.Login;
import com.una.linkhub.model.User;
import com.una.linkhub.repositories.LinkRepository;
import com.una.linkhub.services.UserService;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Login login1 = new Login("zaine1", "123"); 
	    Login login2 = new Login("laysa1", "123");
		
	    User user1 = new User("zaine", "zaine@gmail", login1);
	    User user2 = new User("laysa", "laysa@gmail", login2);

	    userService.insert(user1);
	    userService.insert(user2);
	    
	    Link link1 = new Link(null, "aaaaaaaa", user1);
	    Link link2 = new Link(null, "bbbbbbbb", user2);

	    // Salvar os links
	    linkRepository.saveAll(Arrays.asList(link1, link2));

	    // 5. Associar os links aos usuários e salvar novamente
	    user1.getLinks().add(link1);
	    user2.getLinks().add(link2);
	    
	    
	    
	}
}
