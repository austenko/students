package com.intentsg.service.user.repository;

import com.intentsg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastName(String name) ;

    @Modifying
    @Query(value="update students_ll5.users set first_name= :firstName,last_name= :lastName, alias=:alias  where user_id =:id", nativeQuery=true)
    void updateUserAnyFieldById(String firstName,String lastName,String alias,long id);

}