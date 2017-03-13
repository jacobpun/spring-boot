package org.pk.service;

import java.util.Collection;
import java.util.Optional;

import org.pk.dto.UserCreateRequest;
import org.pk.model.User;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateRequest request);
}