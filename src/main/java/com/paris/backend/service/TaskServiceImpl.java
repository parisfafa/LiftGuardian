package com.paris.backend.service;

import com.paris.backend.model.Device;
import com.paris.backend.model.Job;
import com.paris.backend.model.Task;
import com.paris.backend.model.User;
import com.paris.backend.repository.JobRepository;
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
    public List<Task> findByStatus(int status)
    {
        return taskRepository.findByStatus(status);
    }
    public List<Task> findByUserid(String userid)
    {
       return taskRepository.findByUserid(userid);
    }

    /***
     * 创建维保任务
     * @param userid
     * @throws Exception
     */
    public void createTask(String userid) throws Exception
    {
        User user=userService.findUserByEmail(userid);
        List<Device> devices=deviceMonitoringService.findAllDevices();
        for(Device dev:devices){
            if(user.getOrganization().getId()==dev.getOrganization().getId()){
                Date lastMaintenanTime= DateUtil.stringToDate(dev.getTime());
                int subday=DateUtil.daysBetween(lastMaintenanTime,new Date());//间隔天数
                if(subday>=4)
                {
                    Task task=new Task();
                    dev.setStatus(subday>7?0:1);
                    task.setDevice(dev);
                    task.setUser(user);
                    task.setStatus(subday>7?0:1);  //0超期 1 request
                    Job job=new Job();
                    jobRepository.save(job);
                    task.setJob(job);
                    task.setTask_type(1); //1 ma 2in
                    saveTask(task);
                }

            }
        }
    }

    /***
     * 创建年检
     * @param userid
     * @throws Exceptionins
     */
    public void createTaskins(String userid) throws Exception
    {
        User user=userService.findUserByEmail(userid);
        List<Device> devices=deviceMonitoringService.findAllDevices();
        for(Device dev:devices){
            if(user.getOrganization().getId()==dev.getOrganization().getId()){
                Date lastMaintenanTime= DateUtil.stringToDate(dev.getTime());
                int subday=DateUtil.daysBetween(lastMaintenanTime,new Date());//间隔天数
                if(subday>=365)
                {
                    Task task=new Task();
                    task.setDevice(dev);
                    task.setUser(user);
                    task.setStatus(subday>400?0:1);  //0超期 1 request
                    Job job=new Job();
                    jobRepository.save(job);
                    task.setJob(job);
                    task.setTask_type(2); //1 ma 2in
                    saveTask(task);
                }

            }
        }
    }
}
