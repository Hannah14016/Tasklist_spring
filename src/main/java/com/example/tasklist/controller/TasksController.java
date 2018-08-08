package com.example.tasklist.controller;

import com.example.tasklist.domain.Tasks;
import com.example.tasklist.repository.TasksRepository;
import com.example.tasklist.service.TasksService;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;

@Controller
@RequestMapping("/")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    @GetMapping
    public String index(Model model){
        Iterable<Tasks> tasks = tasksService.findAll();
        model.addAttribute("tasks", tasks);
        return "home";
    }

    @GetMapping("new")
    public String create(Model model) {
        return "create";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Tasks task = tasksService.findOne(id);
        model.addAttribute("task", task);
        return "edit";
    }
    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Tasks task = tasksService.findOne(id);
        model.addAttribute("task", task);
        return  "show";
    }

    @PostMapping
    public String store(@ModelAttribute Tasks task) {
        task.setStatus("ToDo");
        tasksService.save(task);
        return "redirect:/";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Tasks task) {
        task.setId(id);
        tasksService.save(task);
        return "redirect:/";
    }
    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        tasksService.delete(id);
        return "redirect:/";
    }
}
