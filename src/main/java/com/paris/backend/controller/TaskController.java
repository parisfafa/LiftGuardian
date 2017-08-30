package com.paris.backend.controller;

import com.paris.backend.model.*;
import com.paris.backend.secondaryModel.ElevatorStatus;
import com.paris.backend.service.DeviceMonitoringService;
import com.paris.backend.service.TaskService;
import com.paris.backend.service.UserService;
import com.paris.backend.util.DateUtil;
import com.paris.backend.util.GsonHelper;
import io.swagger.models.auth.In;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebResult;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TaskController {

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
    @RequestMapping(value = "/h5plus/saveTask", method = {RequestMethod.GET,RequestMethod.POST})
    public String SaveTask(WebRequest request) {
        //MultipartFile file, @RequestParam(value = "file")
        /**
         * 保存 提交的维保数据
         * img job user time
         */
//        Map<String, Object> map = new HashMap<String, Object>();
//        if (file.isEmpty()) {
//            map.put("message", "文件不能为空");
//           return "0";
//        }
//        if (!isTrue) {
//            map.put("message", "选择正确的文件格式");
//            return "0";
//        }
//        if (file.getSize()>file_size) {
//            map.put("message", "文件大小不能超过2M");
//            return "0";
//        }
//        try {
//            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("你想存放的位置"));
//            map.put("message", "Y");// 文件上传成功
//        } catch (IOException e) {
//            map.put("message", "N");// 文件上传失败
//        }
//        String path = fileString.substring(resourceDir.length());//
//        path = path + fileType;
//        path = path.replace("\\", "/");
//        map.put("fileName", path);

       // String userid=request.getParameter("userid");
//        //System.out.println(user);
        int taskid=Integer.parseInt(request.getParameter("taskid"));
        Task task=taskService.findTaskByTaskid(taskid);
        Job job=task.getJob();
        job.setEntrance1_img_url("11111");
        //job.setEntrance1_comment();
        //saveimg();
        //todo
        //job.setEntrance1_img_url();
        task.setJob(job);
        task.setTime(DateUtil.getSimpleDateFormat().format(new Date()));
        task.setStatus(2);
       // task.getDevice().setStatus(2);
        //task.getDevice().setTime(DateUtil.getSimpleDateFormat().format(new Date()));
        taskService.saveTask(task);
//        List<Task> tasks=taskService.findByUserid(userid);
//        return GsonHelper.modelToJson(tasks);
        return "1";
    }
}
