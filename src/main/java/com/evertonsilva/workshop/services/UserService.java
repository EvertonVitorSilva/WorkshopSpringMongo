package com.evertonsilva.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.evertonsilva.workshop.domain.User;
import com.evertonsilva.workshop.dto.UserDto;
import com.evertonsilva.workshop.ropositories.UserRepository;
import com.evertonsilva.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Obejeto não encontrado!"));
	}
	
	
	public User insert(@RequestBody User obj) {
		return userRepository.insert(obj);
	}
	
	public User fromDTO(UserDto objdto) {
		return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj);
		}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}
	
	
	
}
