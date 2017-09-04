package com.paris.backend.controller;

import com.paris.backend.model.*;

import com.paris.backend.service.DeviceMonitoringService;
import com.paris.backend.service.TaskService;
import com.paris.backend.service.UserService;
import com.paris.backend.util.GsonHelper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebResult;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TaskController {


    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    public static final String ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    @Autowired
    public TaskController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private DeviceMonitoringService deviceMonitoringService;


    @RequestMapping(value = "/mgtdevices", method = RequestMethod.GET)
    public ModelAndView getMgtDevices(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("username"+userDetails.getUsername());
        User user=userService.findUserByEmail(userDetails.getUsername());
        System.out.println("org"+user.getOrganization());
        ModelAndView modelAndView = new ModelAndView();
        List<Device> devices=deviceMonitoringService.findAllDevices();
        List<Device> filter=new ArrayList<Device>();
        for(Device dev:devices){
            if(user.getOrganization().getId()==dev.getOrganization().getId()){
                filter.add(dev);
            }
        }
        modelAndView.addObject("mgtdevices", filter);
        modelAndView.setViewName("mgtdevices");
        return modelAndView;
    }


    @RequestMapping(value="/deviceSchedule", method = RequestMethod.GET)
    public ModelAndView getDeviceSchedule(WebRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int id= Integer.parseInt(request.getParameter("id"));
        int type=Integer.parseInt(request.getParameter("type"));
        List<Schedule> schedule = taskService.findScheduleByDeviceidAndType(id,type);
        //System.out.println(schedule.size()+"size" + schedule.get(0).getId());
        modelAndView.addObject("schedules", schedule.isEmpty()?null:schedule.get(0));
        modelAndView.setViewName("schedule");
        return modelAndView;
    }

    @RequestMapping(value="/newSchedule", method = RequestMethod.GET)
    public ModelAndView newDevice(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("username"+userDetails.getUsername());
        User user=userService.findUserByEmail(userDetails.getUsername());
        System.out.println("org"+user.getOrganization());
        List<Device> devices=deviceMonitoringService.findAllDevices();
        List<Device> filter=new ArrayList<Device>();
        for(Device dev:devices){
            if(user.getOrganization().getId()==dev.getOrganization().getId()){
                filter.add(dev);
            }
        }
        modelAndView.addObject("devices", filter);
        Schedule schedule = new Schedule();
        modelAndView.addObject("schedule", schedule);
        modelAndView.setViewName("newSchedule");
        return modelAndView;
    }



    @RequestMapping(value = "/newSchedule", method = RequestMethod.POST)
    public ModelAndView newSchedule(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        int type = Integer.parseInt(request.getParameter("schedule_type"));
        int deviceid = Integer.parseInt(request.getParameter("device"));
        int existNum = taskService.findScheduleByDeviceidAndType(deviceid,type).size();
        if (existNum>0) {
            modelAndView.addObject("status", "Schedule Exist");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println("username"+userDetails.getUsername());
            User user=userService.findUserByEmail(userDetails.getUsername());
            System.out.println("org"+user.getOrganization());
            List<Device> devices=deviceMonitoringService.findAllDevices();
            List<Device> filter=new ArrayList<Device>();
            for(Device dev:devices){
                if(user.getOrganization().getId()==dev.getOrganization().getId()){
                    filter.add(dev);
                }
            }
            modelAndView.addObject("devices", filter);
            Schedule schedule = new Schedule();
            modelAndView.addObject("schedule", schedule);
            modelAndView.setViewName("newSchedule");
            return modelAndView;
        } else {
            Schedule schedule = new Schedule();
            schedule.setId(Integer.parseInt(request.getParameter("id")));
            //schedule.setOverdue(Integer.parseInt(request.getParameter("overdue")));
            schedule.setSchedule_period(Integer.parseInt(request.getParameter("schedule_period")));
            schedule.setSchedule_type(type);
            schedule.setLast_mtc_ipt_time(request.getParameter("last_mtc_ipt_time"));
            schedule.setNotice_period(Integer.parseInt(request.getParameter("notice_period")));
            //schedule.setDevice(deviceMonitoringService.findDeviceById(Long.parseLong(request.getParameter("deviceid"))).get(0));
            schedule.setDevice(deviceMonitoringService.findDeviceById(Long.parseLong(request.getParameter("device"))).get(0));
            taskService.saveSchedule(schedule);
            modelAndView.addObject("status", "success");
        }
            modelAndView.addObject("successMessage", "Schedule has been added successfully");
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println("username"+userDetails.getUsername());
            User user=userService.findUserByEmail(userDetails.getUsername());
            System.out.println("org"+user.getOrganization());
            List<Device> devices=deviceMonitoringService.findAllDevices();
            List<Device> filter=new ArrayList<Device>();
            for(Device dev:devices){
                if(user.getOrganization().getId()==dev.getOrganization().getId()){
                    filter.add(dev);
                }
            }
            //modelAndView.addObject("devices", filter);
            modelAndView.setViewName("mgtdevices");
            return modelAndView;
    }

    @RequestMapping(value="/editSchedule", method = RequestMethod.GET)
    public ModelAndView editSchedule(WebRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String id=request.getParameter("id");
        Schedule schedule=taskService.findScheduleById(Integer.parseInt(id));
        modelAndView.addObject("schedule", schedule);
        modelAndView.setViewName("editSchedule");
        return modelAndView;
    }

    @RequestMapping(value="/editTask", method = RequestMethod.GET)
    public ModelAndView editTask(WebRequest request){
        ModelAndView modelAndView = new ModelAndView();
        String id=request.getParameter("id");
        Task task=taskService.findTaskByTaskid(Integer.parseInt(id));
        modelAndView.addObject("task", task);
        List<User> users = userService.findAllUsers();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("editTask");
        return modelAndView;
    }

    @RequestMapping(value = "/saveTask", method = RequestMethod.POST)
    public ModelAndView saveTask(@Valid Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Task task1=taskService.findTaskByTaskid(task.getTaskid());
        task1.setUser(task.getUser());
        taskService.saveTask(task1);
        modelAndView.addObject("tasks", task1);
        modelAndView.setViewName("tasks");
        return modelAndView;
    }
    @RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
    public ModelAndView saveSchedule(WebRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Schedule schedule = taskService.findScheduleById(Integer.parseInt(request.getParameter("id")));
        schedule.setSchedule_period(Integer.parseInt(request.getParameter("schedule_period")));
        //schedule.setSchedule_type(Integer.parseInt(request.getParameter("schedule_type")));
        schedule.setNotice_period(Integer.parseInt(request.getParameter("notice_period")));
        //schedule.setDeviceid(Integer.parseInt(request.getParameter("deviceid")));
        taskService.saveSchedule(schedule);
        modelAndView.addObject("schedules", schedule);
        modelAndView.setViewName("schedule");
        return modelAndView;
    }

    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public ModelAndView getTasks(WebRequest request){
        ModelAndView modelAndView = new ModelAndView();
        int id= Integer.parseInt(request.getParameter("id"));
        int type=Integer.parseInt(request.getParameter("type"));

        List<Integer> taskids = taskService.findTasksByDeviceidAndType(id,type);
        List<Task> tasks = new ArrayList<Task>();
        for (int i:taskids)
        {
            System.out.println(i);
            Task task = taskService.findTaskByTaskid(i);
            if(task.getUser()==null)
            {
                User user = new User();
                task.setUser(user);
            }
            tasks.add(task);
        }
        //System.out.println(schedule.size()+"size" + schedule.get(0).getId());
        modelAndView.addObject("tasks", tasks.isEmpty()?null:tasks);
        System.out.println(tasks.toString());
        modelAndView.setViewName("tasks");
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping(value = "/h5plus/findByStatus", method = RequestMethod.GET)
    public String findByStatus(WebRequest request) throws Exception{
        /**
         * 当日工作 0 dalytime 1 request 2 finished  ok
         */
        //String userid=request.getParameter("userid");
        int status=Integer.parseInt(request.getParameter("status"));
        int type=Integer.parseInt(request.getParameter("type"));
        //taskService.createTask(userid);
        List<Task> tasks=taskService.findByStatus(status,type);
        return GsonHelper.modelToJson(tasks);
    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/findByStatusAndUserid", method = RequestMethod.GET)
    public String findByStatusAndUserid(WebRequest request) throws Exception{
        /**
         * 当日工作 0 dalytime 1 request 2 finished  ok
         */
        String userid=request.getParameter("userid");
        int status=Integer.parseInt(request.getParameter("status"));
        int type=Integer.parseInt(request.getParameter("type"));
        //taskService.createTask(userid);
        List<Task> tasks=taskService.findByStatusAndUserid(status,type,userid);
        return GsonHelper.modelToJson(tasks);
    }
    @ResponseBody
    @RequestMapping(value = "/h5plus/findByUserid", method = RequestMethod.GET)
    public String findByUserid(WebRequest request) {
        /**
         * userid   ok
         */
        String userid=request.getParameter("userid");
        //System.out.println(user);
        List<Task> tasks=taskService.findByUserid(userid);
        return GsonHelper.modelToJson(tasks);
    }

    @ResponseBody
    @RequestMapping(value="/h5plus/findByDeviceid", method = RequestMethod.GET)
    public String findByDeviceid(WebRequest request){
//        2，开始维保（点击start按钮）
//   /h5plus/activeTask（userid deviceid type）
//        return task
        String userid=request.getParameter("userid");
        int id= Integer.parseInt(request.getParameter("deviceid"));
        int type=Integer.parseInt(request.getParameter("type"));

        List<Integer> taskids = taskService.findTasksByDeviceidAndType(id,type);
        List<Task> tasks = new ArrayList<Task>();
        for (int i:taskids)
        {
            System.out.println(i);
            Task task = taskService.findTaskByTaskid(i);
            if(task.getUser()==null)
            {
                User user = userService.findUserByEmail(userid);
                task.setUser(user);
                taskService.saveTask(task);
            }
            tasks.add(task);
        }
        System.out.println(GsonHelper.modelToJson(tasks));
        return GsonHelper.modelToJson(tasks);
    }
    @ResponseBody
    @RequestMapping(value = "/h5plus/findByTime", method = RequestMethod.GET)
    public String findByTime(WebRequest request) {
        /**
         * userid
         */
        String userid = request.getParameter("userid");
        String time = request.getParameter("time");
        int type=Integer.parseInt(request.getParameter("type"));
        List<Task> tasks=taskService.findByStartTime(time,type);
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getUser().getEmail().equals(userid))
            {
                userTasks.add(task);
            }
        }
        return GsonHelper.modelToJson(userTasks);
    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/findByTimeAndStatus", method = RequestMethod.GET)
    public String findByTimeAndStatus(WebRequest request) {
        /**
         * userid
         */
        String userid = request.getParameter("userid");
        int status=Integer.parseInt(request.getParameter("status"));
        String time = request.getParameter("time");
        int type=Integer.parseInt(request.getParameter("type"));
        List<Task> tasks=taskService.findByStartTimeAndStatus(time,type,status);
        ArrayList<Task> userTasks = new ArrayList<Task>();
        for (Task task:tasks)
        {
            if(task.getUser().getEmail().equals(userid))
            {
                userTasks.add(task);
            }
        }
        return GsonHelper.modelToJson(userTasks);
    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/saveTask", method = {RequestMethod.GET})
   public String SaveTask( WebRequest request) {

//   /h5plus/activeTask（userid deviceid type）
//        return task
            String userid=request.getParameter("userid");
            int id= Integer.parseInt(request.getParameter("deviceid"));
            int type=Integer.parseInt(request.getParameter("type"));

            List<Integer> taskids = taskService.findTasksByDeviceidAndType(id,type);
//            List<Task> tasks = new ArrayList<Task>();
            for (int i:taskids)
            {
                System.out.println(i);
                Task task = taskService.findTaskByTaskid(i);
                task.getJob().setEntrance1_comment(request.getParameter("hoistway1_comment"));
                task.setStatus(4);
                taskService.saveTask(task);
//                Schedule schedule =  taskService.findScheduleByDeviceidAndType(Integer.parseInt(task.getDevice().getId().toString()),1).get(0);
//                schedule.setTask_inperiod(false);
//                schedule.setStatus(4);
//                taskService.saveSchedule(schedule);
//                tasks.add(task);
            }
            return "1";
        }

}
