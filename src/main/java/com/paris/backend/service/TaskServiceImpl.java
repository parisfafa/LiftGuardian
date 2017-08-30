package com.paris.backend.service;

import com.paris.backend.model.*;
import com.paris.backend.repository.JobRepository;
import com.paris.backend.repository.ScheduleRepository;
import com.paris.backend.repository.TaskRepository;
import com.paris.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService{


    @Autowired
    private DeviceMonitoringService deviceMonitoringService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

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
        return taskRepository.findAll();
    }
    public void deleteTaskByTaskid(int taskid)
    {
        taskRepository.delete(taskid);
    }
    public List<Task> findByStatus(int status,int type)
    {
        ArrayList<Task> tasks = (ArrayList<Task>)taskRepository.findAll();
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getStatus()==status&&task.getTask_type()==type)
            {
                userTasks.add(task);
            }
        }
        return userTasks;
        //return taskRepository.findTasksByStatusAndTask_type(status,type);
    }
    public List<Task> findByStatusAndUserid(int status,int type,String userid)
    {
        //ArrayList<Task> tasks = (ArrayList<Task>)taskRepository.findTasksByStatusAndTask_type(status,type);
        ArrayList<Task> tasks = (ArrayList<Task>)taskRepository.findAll();
        ArrayList<Task> statusTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getStatus()==status&&task.getTask_type()==type)
            {
                statusTasks.add(task);
            }
        }
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:statusTasks)
        {
            if(task.getUser().getEmail().equals(userid))
            {
                userTasks.add(task);
            }
        }
        return userTasks;
    }
    public List<Task> findByUserid(String userid)
    {
       ArrayList<Task> tasks = (ArrayList<Task>)taskRepository.findAll();
       ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getUser().getEmail().equals(userid))
            {
                userTasks.add(task);
            }
        }
       return userTasks;
    }
    public List<Schedule> findScheduleByDeviceidAndType(int deviceid,int scheduleType)
    {
        return scheduleRepository.findScheduleByDeviceAndSchedule_typeOrderByIdDesc(deviceid,scheduleType);
    }
    public void saveSchedule(Schedule schedule)
    {
        scheduleRepository.save(schedule);
    }
    public List<Schedule> findAllSchedule()
    {
        return scheduleRepository.findAll();
    }
    public Schedule findScheduleById(int id)
    {
        return scheduleRepository.findOne(id);
    }
    public List<Integer> findTasksByDeviceidAndType(int deviceid,int type)
    {
        return taskRepository.findByDeviceid(deviceid);
    }

    public List<Task> findByStartTime(String time,int type)
    {
        ArrayList<Task> tasks = (ArrayList<Task>)taskRepository.findAll();
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getStart_time().equals(time)&&task.getTask_type()==type)
            {
                userTasks.add(task);
            }
        }
        return userTasks;
        //return taskRepository.findTasksByStart_timeAndTask_type(time,type);
    }
    public List<Task> findByStartTimeAndStatus(String time,int type,int status)
    {
        ArrayList<Task> tasks = (ArrayList<Task>)taskRepository.findAll();
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getStart_time().equals(time)&&task.getTask_type()==type&&task.getStatus()==status)
            {
                userTasks.add(task);
            }
        }
        return userTasks;
        //return taskRepository.findTasksByStart_timeAndTask_typeAndStatus( time, type,status);
    }

}
