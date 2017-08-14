package com.paris.backend.repository;

import com.paris.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Integer> {
   List<Task> findByUserid(String userid);
   List<Task> findByTime(String time);
}
