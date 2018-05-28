/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.controller;

import hello.domain.Role;
import hello.domain.User;
import hello.repository.RoleRepository;
import hello.repository.UserRepository;
import hello.validator.UserValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import hello.service.SecurityService;
//import hello.service.UserService;
//import hello.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Ecyola
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping({"/", "/list"})
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users/user-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String registartion(Model model) {
        User user = new User();
        user.setRole((List<Role>) roleRepository.findAll());
        model.addAttribute("user", user);
        return "users/user-form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, Model model) {

        userRepository.save(user);
        model.addAttribute("user", user);
        return "users/user";
    }

    @RequestMapping("/{id}")
    public String getUser(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "users/user";
    }

}
