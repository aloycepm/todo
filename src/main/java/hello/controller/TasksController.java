/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.controller;

import hello.domain.Tasks;
import hello.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private TasksService tasksService;

    @Autowired
    public void setTasksRepository(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Autowired
    public void setTasksService(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @RequestMapping({"/list", "/"})
    public String listTasks(Model model) {
        model.addAttribute("tasks", tasksService.findAll());
        return "tasks/tasks-list";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "tasks/tasks-add";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam String id,
            Model model) {
        Integer ID = Integer.parseInt(id);
        model.addAttribute("task",
                tasksService.findById(ID).get());
        return "tasks/tasks-confirm-delete";
    }

    @RequestMapping("/create")
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
        tasksService.save(t);
        return new RedirectView("/tasks/list");
    }

    @RequestMapping("/show")
    public String show(@RequestParam String id,
            Model model) {
        Integer ID = Integer.parseInt(id);
        model.addAttribute("task", tasksService.findById(ID).get());
        return "tasks/tasks-show";
    }

    @RequestMapping("/update")
    public RedirectView update(
            @RequestParam(required = true) String id,
            @RequestParam(required = true) String activity,
            @RequestParam(required = true) String date,
            @RequestParam(required = true) String time,
            Model model
    ) {

        Integer ID = Integer.parseInt(id);
        Tasks t = tasksService.findById(ID).get();
        t.setActivity(activity);
        t.setDate(date);
        t.setTime(time);
        tasksService.save(t);

        return new RedirectView("/tasks/list");
    }

    @RequestMapping("/delete")
    public RedirectView delete(@RequestParam String id) {
        Integer ID = Integer.parseInt(id);
        tasksService.deleteById(ID);
        return new RedirectView("/tasks/list");
    }

}
