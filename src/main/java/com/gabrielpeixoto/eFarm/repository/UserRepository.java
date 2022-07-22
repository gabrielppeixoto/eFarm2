package com.gabrielpeixoto.eFarm.repository;

import com.gabrielpeixoto.eFarm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByCompleteName(String completeName);
    public User findByIdentityNumber(String identityNumber);
    public User findByEmail(String email);
}
