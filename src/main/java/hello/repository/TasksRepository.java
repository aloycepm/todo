/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.repository;

import hello.Tasks;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ecyola
 */
public interface TasksRepository extends CrudRepository<Tasks, Integer> {
    
}
