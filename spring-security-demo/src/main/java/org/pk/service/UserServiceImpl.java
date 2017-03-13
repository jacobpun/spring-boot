package org.pk.service;

import java.util.Collection;
import java.util.Optional;

import org.pk.dto.UserCreateRequest;
import org.pk.model.User;
import org.pk.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	@PreAuthorize("@accessControlService.canAccessUser(#id)")
	public Optional<User> getUserById(long id) {
		return Optional.ofNullable(userRepo.findOne(id));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	@PreAuthorize("hasAuthority('ADMIN')")
	public Collection<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User create(UserCreateRequest request) {
		String passwordHash = new BCryptPasswordEncoder().encode(request.getPassword());
		User user = new User(request.getEmail(), passwordHash, request.getRole());
		return userRepo.save(user);
	}
}