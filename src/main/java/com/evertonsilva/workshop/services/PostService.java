package com.evertonsilva.workshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evertonsilva.workshop.domain.Post;
import com.evertonsilva.workshop.ropositories.PostRepository;
import com.evertonsilva.workshop.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Obejeto não encontrado!"));
	}
	
	

}
