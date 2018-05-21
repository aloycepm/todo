/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.controller;

import hello.Tasks;
import hello.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Ecyola
 */
@Controller
@RequestMapping(path = "/tasks")
public class TasksController {

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping(path = "/")
    public RedirectView index() {
        return new RedirectView("/tasks/list");
    }

    @GetMapping(path = "/list")
    public String listTasks(Model model) {
        model.addAttribute("tasks", tasksRepository.findAll());
        return "tasks-list";
    }

    @GetMapping(path = "/add")
    public String add(Model model) {
        return "tasks-add";
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam String id,
            Model model) {
        Integer ID = Integer.parseInt(id);
        model.addAttribute("task",
                tasksRepository.findById(ID).get());
        return "tasks-confirm-delete";
    }

    @GetMapping(path = "/create")
    public RedirectView create(
            @RequestParam(required = true) String activity,
            @RequestParam(required = true) String date,
            @RequestParam(required = true) String time,
            Model model
    ) {
        Tasks t = new Tasks();
        t.setActivity(activity);
        t.setDate(date);
        t.setTime(time);
        tasksRepository.save(t);
        return new RedirectView("/tasks/list");
    }

    @GetMapping(path = "/show")
    public String show(@RequestParam String id,
            Model model) {
        Integer ID = Integer.parseInt(id);
        model.addAttribute("task", tasksRepository.findById(ID).get());
        return "tasks-show";
    }

    @GetMapping(path = "/update")
    public RedirectView update(
            @RequestParam(required = true) String id,
            @RequestParam(required = true) String activity,
            @RequestParam(required = true) String date,
            @RequestParam(required = true) String time,
            Model model
    ) {

        Integer ID = Integer.parseInt(id);
        Tasks t = tasksRepository.findById(ID).get();
        t.setActivity(activity);
        t.setDate(date);
        t.setTime(time);
        tasksRepository.save(t);

        return new RedirectView("/tasks/list");
    }

    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam String id) {
        Integer ID = Integer.parseInt(id);
        tasksRepository.deleteById(ID);
        return new RedirectView("/tasks/list");
    }

}
