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
                    userDTO.setUserDTO(e.getAlias());
                    userDTO.setUserDTOId(e.getUserId());
                    return userDTO;
                }).collect(Collectors.toList());
        return userDTOs;
    }

    public List<UserDTO> getUsersByLastName(String name){
        List<UserDTO> userDTOs =userRepository.findByLastName(name).stream()
                .map(e->{
                    UserDTO userDTO=new UserDTO();
                    userDTO.setUserDTO(e.getAlias());
                    userDTO.setUserDTOId(e.getUserId());
                    return userDTO;
                }).collect(Collectors.toList());
        return userDTOs;
    }

    public UserDTO getUserById(long id){
        User user = userRepository.findUserByUserId(id);
        UserDTO userDTO=new UserDTO();
        userDTO.setUserDTO(user.getAlias());
        userDTO.setUserDTOId(user.getUserId());
        return userDTO;
    }

    User autoCompleteFields(User userSourse,User userOrigin){
        if(userSourse.getFirstName()!=null) {
            userOrigin.setFirstName(userSourse.getFirstName());
        }

        if(userSourse.getLastName()!=null){
            userOrigin.setLastName(userSourse.getLastName());
        }

        if(userSourse.getAlias()!=null){
            userOrigin.setAlias(userSourse.getAlias());
        }
        return userOrigin;
    }

    @Transactional
    public void updateUserAnyFieldByIdByReposytoryInBoxMethod(User userSourse){
        User userOrigin = userRepository.findUserByUserId(userSourse.getUserId());

        userOrigin= autoCompleteFields(userSourse,userOrigin);

        userRepository.save(userOrigin);
    }

    public void createUsr(User user){
        userRepository.save(user);

    }

    public void deleteUsrById(long id){
        userRepository.deleteByUserId(id);

    }
}
