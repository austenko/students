package com.intentsg.service.user.repository;

import com.intentsg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    List<User>findByFirstName(String firstName);

    List<User> getUserByUserId(Long userId);
//@Query("SELECT u From User u WHERE u.firstName = :firstName")
// List<User> findAllByFirstName(@Param ("firstName") String enterFirstName);

//@Query("SELECT s FROM User s WHERE s.firstName = : string OR s.lastName = :string")
//    List<User> findAllByAll(@Param("string") String eneterString);




}
