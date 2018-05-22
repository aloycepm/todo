/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.model.User;
import hello.repository.RoleRepository;
import hello.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired

    private UserRepository userRepository;

    @Autowired

    private RoleRepository roleRepository;

    @Autowired

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override

    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
// TODO: role needed
        userRepository.save(user);

    }

    @Override

    public User findByUsername(String username) {

        return userRepository.findByUsername(username);

    }

}
