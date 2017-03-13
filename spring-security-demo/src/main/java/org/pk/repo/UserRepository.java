package org.pk.repo;

import java.util.Optional;

import org.pk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}