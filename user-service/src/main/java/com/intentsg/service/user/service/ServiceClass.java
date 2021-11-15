package com.intentsg.service.user.service;

import com.intentsg.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {
    @Autowired
    UserRepository userRepository;

}
