package edu.uph.ii.lab1.service;

import edu.uph.ii.lab1.models.User;
import edu.uph.ii.lab1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
public class UserServiceImpl implements UserServiceImpla {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional( readOnly = true)
    public User findByUsernameOrEmail(String usernameOrEmail) {
        User user = null;
        try {
            user = userRepository.findByUsernameOrEmail(usernameOrEmail);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

}