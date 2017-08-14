package com.paris.backend.service;

import com.paris.backend.model.Task;
import com.paris.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService{


    @Autowired
    private TaskRepository taskRepository;

    public Task findTaskByTaskid(int taskid)
    {
        return taskRepository.findOne(taskid);
    }
    public void saveTask(Task task)
    {
        taskRepository.save(task);
    }
    public List<Task> findAllTasks()
    {
        taskRepository.findAll();
    }
    public void deleteTaskByTaskid(int taskid)
    {
        taskRepository.delete(taskid);
    }
    public List<Task> findByTime(String time) {return taskRepository.findByTime(time);}
    public List<Task> findByUserid(String userid)
    {
       return taskRepository.findByUserid(userid);
    }

}
