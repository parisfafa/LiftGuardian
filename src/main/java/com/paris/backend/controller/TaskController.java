package com.paris.backend.controller;

import com.paris.backend.model.*;
import com.paris.backend.service.DeviceMonitoringService;
import com.paris.backend.service.TaskService;
import com.paris.backend.service.UserService;
import com.paris.backend.util.DateUtil;
import com.paris.backend.util.GsonHelper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebResult;
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

//    @ResponseBody
//    @RequestMapping(value = "/h5plus/findTasks", method = RequestMethod.GET)
//    public String findAllTasks() {
//        //System.out.println(user);
//        List<Task> tasks=taskService.findAllTasks();
//        return GsonHelper.modelToJson(tasks);
//    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/findByStatus", method = RequestMethod.GET)
    public String findByStatus(WebRequest request) throws Exception{
        /**
         * 当日工作 0 dalytime 1 request 2 finished
         */
        String userid=request.getParameter("userid");
        int status=Integer.parseInt(request.getParameter("status"));
        taskService.createTask(userid);
        List<Task> tasks=taskService.findByStatus(status);
        return GsonHelper.modelToJson(tasks);
    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/findByUserid", method = RequestMethod.GET)
    public String findByUserid(WebRequest request) {
        /**
         * 当日工作
         */
        String userid=request.getParameter("userid");
        //System.out.println(user);
        List<Task> tasks=taskService.findByUserid(userid);
        return GsonHelper.modelToJson(tasks);
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
        task.getDevice().setStatus(2);
        task.getDevice().setTime(DateUtil.getSimpleDateFormat().format(new Date()));
        taskService.saveTask(task);
//        List<Task> tasks=taskService.findByUserid(userid);
//        return GsonHelper.modelToJson(tasks);
        return "1";
    }
}
