package com.evertonsilva.workshop.ropositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evertonsilva.workshop.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
