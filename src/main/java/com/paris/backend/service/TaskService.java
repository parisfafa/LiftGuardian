package com.paris.backend.service;

import com.paris.backend.model.Job;
import com.paris.backend.model.Schedule;
import com.paris.backend.model.Task;

import java.util.List;

public interface TaskService {
    public Task findTaskByTaskid(int taskid);
    public void saveTask(Task task);
    public List<Task> findAllTasks();
    public void deleteTaskByTaskid(int taskid);
    public List<Task> findByStatus(int status,int type);
    public List<Task> findByStatusAndUserid(int status,int type,String userid);
    public List<Task> findByUserid(String userid);
    public List<Schedule> findScheduleByDeviceidAndType(int deviceid,int scheduleType);
    public void saveSchedule(Schedule schedule);
    public List<Schedule> findAllSchedule();
    public Schedule findScheduleById(int id);
    public List<Integer> findTasksByDeviceidAndType(int deviceid,int type);
    public List<Task> findByStartTime(String time,int type);
    public List<Task> findByStartTimeAndStatus(String time,int type,int status);
}
