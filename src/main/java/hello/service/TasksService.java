/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.domain.Tasks;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ecyola
 */
public interface TasksService extends CrudRepository<Tasks, Integer> {
}
