package com.example.tasklist.repository;

import com.example.tasklist.domain.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Long> {
}
