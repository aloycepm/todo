/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.model.User;

/**
 *
 * @author Ecyola
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
