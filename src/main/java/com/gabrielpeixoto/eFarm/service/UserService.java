package com.gabrielpeixoto.eFarm.service;

import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getUsersByName(String name);
    User getUserByIdentityNumber(String idn);
    User updateUser(User user);
    void deleteUserById(Long id);
}
