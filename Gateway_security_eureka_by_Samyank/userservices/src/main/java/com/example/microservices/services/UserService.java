package com.example.microservices.services;

import com.example.microservices.entities.User;
import com.example.microservices.exceptions.ResourceNotFoundExceptions;
import com.example.microservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public User saveUser(User user){
    	User nuser = new User();
    	nuser.setPassword(user.getPassword());
    	nuser.setId(user.getId()+1);
    	nuser.setName(user.getName());
    	
//    	userRepository.save(nuser);
//    	if(1==1) throw new RuntimeException("user");
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        
       return  userRepository.save(user);
    }

    public List<User> getAllUsers(){
         return userRepository.findAll();

    }

    public User getUser(Long id){
       return userRepository.findById(id).orElseThrow( ()->new ResourceNotFoundExceptions("User with given id is not found on server !! "+id ));
    }

}
