package com.gabrielpeixoto.eFarm.service.impl;

import com.gabrielpeixoto.eFarm.entity.User;
import com.gabrielpeixoto.eFarm.repository.UserRepository;
import com.gabrielpeixoto.eFarm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id)
    {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getUsersByName(String name)
    {
        return userRepository.findByCompleteName(name);
    }

    @Override
    public User getUserByIdentityNumber(String idn)
    {
        return userRepository.findByIdentityNumber(idn);
    }

    @Override
    public User updateUser(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id)
    {
        userRepository.deleteById(id);
    }
}
