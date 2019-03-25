package com.upvote.service;

import com.upvote.domain.Role;
import com.upvote.domain.User;
import com.upvote.dto.UserForm;
import com.upvote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        //All created user accounts are voters by default
        user.setRole(Role.ROLE_VOTER);

        userRepo.save(user);
    }
}