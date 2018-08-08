package com.example.tasklist.service;

import java.util.List;

import com.example.tasklist.domain.Tasks;
import com.example.tasklist.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TasksService {
    @Autowired
    private TasksRepository tasksRepository;

    public Iterable<Tasks> findAll(){
        return tasksRepository.findAll();
    }

    public Tasks findOne(Long id) {
        return tasksRepository.findById(id).get();
    }

    public Tasks save(Tasks task) {
        return tasksRepository.save(task);
    }

    public void delete(Long id) {
        tasksRepository.delete(findOne(id));
    }
}
