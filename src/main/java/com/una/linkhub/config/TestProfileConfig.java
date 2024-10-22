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
import com.una.linkhub.repositories.LoginRepository;
import com.una.linkhub.services.UserService;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "zaine", "zaine@gmail");
	    User user2 = new User(null, "laysa", "laysa@gmail");
	    
	    userService.insert(user1);
	    userService.insert(user2);

	    //------------------------------------
	    Login login1 = new Login(null, "zaine1", "123", user1);
	    Login login2 = new Login(null, "laysa1", "123", user2);
	    
	    loginRepository.saveAll(Arrays.asList(login1, login2));

	    user1.setCredenciais(login1);
	    user2.setCredenciais(login2);
	    
	    userService.insert(user1);
	    userService.insert(user2);
	    
	    //-----------------------------------------------
	    
	    Link link1 = new Link(null, "aaaaaaaa", user1);
	    Link link2 = new Link(null, "bbbbbbbb", user2);

	    linkRepository.saveAll(Arrays.asList(link1, link2));
	    
	    user1.getLinks().add(link1);
	    user2.getLinks().add(link2);
	    
	    userService.insert(user1);
	    userService.insert(user2);
	}

}
