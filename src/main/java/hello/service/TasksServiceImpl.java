/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.service;

import hello.Tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ecyola
 */
@Service
public class TasksServiceImpl implements TasksService {

    private Map<Integer, Tasks> Tasks;

    public TasksServiceImpl() {
    }

    @Override
    public List<Tasks> listAllTasks() {
        return new ArrayList<>(Tasks.values());
    }

}
