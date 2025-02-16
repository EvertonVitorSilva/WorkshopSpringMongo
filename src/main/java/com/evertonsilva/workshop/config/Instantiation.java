package com.evertonsilva.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.evertonsilva.workshop.domain.Post;
import com.evertonsilva.workshop.domain.User;
import com.evertonsilva.workshop.dto.AuthorDTO;
import com.evertonsilva.workshop.dto.ComentDTO;
import com.evertonsilva.workshop.ropositories.PostRepository;
import com.evertonsilva.workshop.ropositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/10/2025"), "Partiu Cancun", "Indo viajar para Cancun", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/10/2025"), "Incrível", "Cheguei em Cancun e as praias são maravilhosas", new AuthorDTO(maria));
		
		ComentDTO c1 = new ComentDTO("Boa viagem", sdf.parse("21/03/2025"), new AuthorDTO(alex));
		ComentDTO c2 = new ComentDTO("Um dia irei visitar", sdf.parse("25/11/2025"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
		
	}

}
