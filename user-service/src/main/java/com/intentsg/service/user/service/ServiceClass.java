package com.intentsg.service.user.service;

import com.intentsg.model.User;
import com.intentsg.service.user.repository.UserRepository;
import com.intentsg.service.user.userdto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceClass {
    @Autowired
    UserRepository userRepository;


    public List<UserDto> findAllUsers(){
        List<UserDto> list=userRepository.findAll().stream()
                .map(e->{
                    UserDto userDto= new UserDto();
                    userDto.setUserNameDto(e.getFirstName());
                    userDto.setUserIdDto(e.getUserId());
                    return userDto;
                }).collect(Collectors.toList());
        return list;
    }


//    public List<UserDto> getUsersByByUserId(Long userIdDto){
//        List<UserDto> dtoList=userRepository.getUserByUserId(userIdDto).stream()
//                .map(e->{
//                    UserDto userDto=new UserDto();
//                    userDto.getUserIdDto();
//                    userDto.getUserIdDto();
//                    return userDto;
//                }).collect(Collectors.toList());
//        return dtoList;
//    }
    public List<UserDto> findAllByFirstName(String firstName){
        List<UserDto> list = userRepository.findByFirstName(firstName).stream()
                .map(e->{
                    UserDto userDto = new UserDto() ;
                    userDto.setUserNameDto(e.getFirstName());
                    return userDto;
                }).collect(Collectors.toList());
        return list;
    }


}
