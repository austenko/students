package com.intentsg.service.user.service;

import com.intentsg.model.User;
import com.intentsg.service.user.dto.UserDTO;
import com.intentsg.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUserList(){
        List<UserDTO> userDTOs =userRepository.findAll().stream()
                .map(e->{
                    UserDTO userDTO=new UserDTO();
                    userDTO.setName(e.getAlias());
                    return userDTO;
                }).collect(Collectors.toList());
        return userDTOs;
    }

    public List<UserDTO> getUsersByLastName(String name){
        List<UserDTO> userDTOs =userRepository.findByLastName(name).stream()
                .map(e->{
                    UserDTO userDTO=new UserDTO();
                    userDTO.setName(e.getAlias());
                    return userDTO;
                }).collect(Collectors.toList());
        return userDTOs;
    }

    public UserDTO getUserById(long id){
        User user = userRepository.findUserByUserId(id);
        UserDTO userDTO=new UserDTO();
        userDTO.setName(user.getAlias());
        return userDTO;
    }

    public void createUsr(User user){
        userRepository.save(user);
    }

    public void deleteUsrById(long id){
        userRepository.deleteByUserId(id);
    }
}
