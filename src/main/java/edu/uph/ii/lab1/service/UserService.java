package edu.uph.ii.lab1.service;

import edu.uph.ii.lab1.models.User;

public interface UserService {
    User findByUsernameOrEmail(String usernameOrEmail);
}
