/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.controller;

import hello.model.User;
//import hello.service.SecurityService;
//import hello.service.UserService;
//import hello.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ecyola
 */
@Controller
public class UserController {

//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registartion(Model model) {
        model.addAttribute("userform", new User());
        return "registration";
    }

//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String registration(@ModelAttribute("userForm") User userForm,
//            BindingResult bindingResult, Model model) {
//
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//
//            return "registration";
//
//        }
//        userService.save(userForm);
//
//        securityService.autologin(userForm.getUsername(),
//                userForm.getPasswordConfirm());
//
//        return "redirect:/home";
//
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid username or password");
        }

        if (logout != null) {
            model.addAttribute("message", "You have loged out successfully");
        }

        return "login";
    }
    
    
}
