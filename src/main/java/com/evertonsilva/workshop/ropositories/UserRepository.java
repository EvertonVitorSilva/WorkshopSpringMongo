package com.evertonsilva.workshop.ropositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.evertonsilva.workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
}
