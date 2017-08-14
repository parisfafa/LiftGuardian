package com.paris.backend.controller;

import com.paris.backend.model.Role;
import com.paris.backend.model.Task;
import com.paris.backend.service.TaskService;
import com.paris.backend.service.UserService;
import com.paris.backend.util.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.jws.WebResult;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @ResponseBody
    @RequestMapping(value = "/h5plus/findTasks", method = RequestMethod.GET)
    public String findAllTasks() {
        //System.out.println(user);
        List<Task> tasks=taskService.findAllTasks();
        return GsonHelper.modelToJson(tasks);
    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/findByTime", method = RequestMethod.GET)
    public String findByTime(WebRequest request) {
        /**
         * 当日工作
         */
        String time=request.getParameter("time");
        //System.out.println(user);
        List<Task> tasks=taskService.findByTime(time);
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
    @RequestMapping(value = "/h5plus/findByUserid", method = RequestMethod.GET)
    public String findJobByid(WebRequest request) {
        /**
         * 当日工作
         */
        String userid=request.getParameter("userid");
        //System.out.println(user);
        List<Task> tasks=taskService.findByUserid(userid);
        return GsonHelper.modelToJson(tasks);
    }

    @ResponseBody
    @RequestMapping(value = "/h5plus/saveTask", method = RequestMethod.GET)
    public String SaveTask(WebRequest request) {
        /**
         * 保存 提交的维保数据
         * img job user time
         */
//        String userid=request.getParameter("userid");
//        //System.out.println(user);
//        List<Task> tasks=taskService.findByUserid(userid);
//        return GsonHelper.modelToJson(tasks);
        return "1";
    }
}
