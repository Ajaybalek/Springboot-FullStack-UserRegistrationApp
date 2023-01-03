package com.codeWithAjay.fullStackBackend.controller;

import com.codeWithAjay.fullStackBackend.exception.UserNotFoundException;
import com.codeWithAjay.fullStackBackend.model.User;
import com.codeWithAjay.fullStackBackend.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class userController {
    @Autowired
    private userRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }


    @GetMapping("/users")
    List<User> getAll(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getById(@PathVariable long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping ("/user/{id}")
    User UpdateById(@RequestBody User newUser,@PathVariable long id){
       return userRepository.findById(id).map(user->{
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteById(@PathVariable long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "user with id:"+id+" has been deleted";
    }
}
