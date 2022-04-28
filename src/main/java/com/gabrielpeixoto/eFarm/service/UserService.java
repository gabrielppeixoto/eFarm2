package com.gabrielpeixoto.eFarm.service;

import com.gabrielpeixoto.eFarm.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getUsersByName(String name);
    User getUserByIdentityNumber(String idn);
    User updateUser(User user);
    void deleteUserById(Long id);
}
