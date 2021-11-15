package com.intentsg.service.user.repository;

import com.intentsg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUserByUserId(Long userId);
    List<User> findAllByFirstName(String userName);

}
