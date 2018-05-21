/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.controller;

import hello.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ecyola
 */
@Controller
@RequestMapping(path = "/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(path="/list")
    public @ResponseBody Iterable<User> listUsers(){
        return userRepository.findAll();
    }
}
