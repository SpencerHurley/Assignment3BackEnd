package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import webdev.models.User;
import webdev.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/api/user")	
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	@PostMapping("/api/user/")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/api/user/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") int id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) { 
		if (userRepository.findUserByUsername(user.getUsername()) == null) {
			return this.createUser(user);
		} else {
			return userRepository.findUserByUsername(user.getUsername());
		}
	}

	
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int id, @RequestBody User user) {
		Optional<User> maybeUser = userRepository.findById(id);
		if (maybeUser.isPresent()) {
			User u = maybeUser.get();
			u.set(user);
			userRepository.save(u);
		}
		return null;
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.deleteById(id);
	}
	
}
