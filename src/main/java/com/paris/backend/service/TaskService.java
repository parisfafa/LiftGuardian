package com.paris.backend.service;

import com.paris.backend.model.Task;

import java.util.List;

public interface TaskService {
    public Task findTaskByTaskid(int taskid);
    public void saveTask(Task task);
    public List<Task> findAllTasks();
    public void deleteTaskByTaskid(int taskid);
    public List<Task> findByTime(String time);
    public List<Task> findByUserid(String userid);
}
