package edu.uph.ii.lab1.service;

import edu.uph.ii.lab1.models.User;

public interface UserServiceImpla {
    User findByUsernameOrEmail(String usernameOrEmail);
}
