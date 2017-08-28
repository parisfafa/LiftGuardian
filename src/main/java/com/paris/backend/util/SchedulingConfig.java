package com.paris.backend.util;

import com.paris.backend.model.Device;
import com.paris.backend.model.Job;
import com.paris.backend.model.Schedule;
import com.paris.backend.model.Task;
import com.paris.backend.repository.JobRepository;
import com.paris.backend.service.DeviceMonitoringService;
import com.paris.backend.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

/**
 * 定时任务配置类
 *
 * @author achen
 *
 * @create 2017年8月21日
 */
@Configuration
@EnableScheduling // 启用定时任务
public class SchedulingConfig {

    @Autowired
    private DeviceMonitoringService deviceMonitoringService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private JobRepository jobRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
    public void scheduler() {
        logger.info(">>>>>>>>>>>>> scheduled start... ");
        //User user=userService.findUserByEmail(userid);
        List<Device> devices=deviceMonitoringService.findAllDevices();
        for(Device dev:devices)
        {
            List<Schedule> Mschedules =taskService.findScheduleByDeviceidAndType(Integer.parseInt(dev.getId().toString()),1);
            if(Mschedules.size()>0)
            {
                if(!Mschedules.get(0).getTask_inperiod())
                {
                    doCreateTask(Mschedules.get(0),dev);
                }
            }
            List<Schedule> Ischedules =taskService.findScheduleByDeviceidAndType(Integer.parseInt(dev.getId().toString()),2);
            if(Ischedules.size()>0)
            {
                if(!Ischedules.get(0).getTask_inperiod())
                {
                    doCreateTask(Ischedules.get(0),dev);
                }
            }

        }
    }
    public void doCreateTask(Schedule schedule,Device dev)
    {
        try {
            Date lastMaintenanTime= DateUtil.stringToDate(schedule.getLast_mtc_ipt_time());
            int subday=DateUtil.daysBetween(lastMaintenanTime,new Date());//间隔天数
            if(subday>=schedule.getNotice_period())
            {
                Task task=new Task();
                schedule.setStatus(1);
                schedule.setTask_inperiod(true);
                task.setDevice(dev);
                task.setStatus(1);  //0超期 1 request
                Job job=new Job();
                jobRepository.save(job);
                task.setJob(job);
                task.setTask_type(schedule.getSchedule_type()); //1 ma 2in
                taskService.saveTask(task);
                taskService.saveSchedule(schedule);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}