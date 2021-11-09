package com.intentsg.service.user.repository;

import com.intentsg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    List<User> findByLastName(String name) ;
    User findUserByUserId(long id) ;
    User save(User user);

    @Transactional
    void deleteByUserId(long id);
}