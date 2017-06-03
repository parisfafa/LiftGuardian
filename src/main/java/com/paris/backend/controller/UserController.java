package com.paris.backend.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.paris.backend.model.Role;
import com.paris.backend.model.User;
import com.paris.backend.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> userList=userService.findAllUsers();
		List<Role> roleList=userService.findAllRoles();
		modelAndView.addObject("users", userList);
		modelAndView.addObject("roles", roleList);
		modelAndView.setViewName("users");
		return modelAndView;
	}
	@RequestMapping(value="/editUser", method = RequestMethod.POST)
	public ModelAndView delete(WebRequest request){
		
		System.out.println("fafa"+request.getParameter("id")+request.getParameter("oper"));
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			userService.deleteUserById(id);
		}

		ModelAndView modelAndView = new ModelAndView();
		List<User> userList=userService.findAllUsers();
		modelAndView.addObject("users", userList);
		modelAndView.setViewName("users");
		return modelAndView;
	}
	
	@RequestMapping(value="/roles", method = RequestMethod.GET)
	public ModelAndView roles(){
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roleList=userService.findAllRoles();
		modelAndView.addObject("roles", roleList);
		modelAndView.setViewName("roles");
		return modelAndView;
	}
	@RequestMapping(value="/editRole", method = RequestMethod.POST)
	public ModelAndView deleteRole(WebRequest request){

		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			userService.deleteUserById(id);
		}
		if("add".equals(request.getParameter("oper"))){
			Role role=new Role();
			role.setRole(request.getParameter("role"));
			System.out.println("fafa"+request.getParameter("role"));
			userService.saveRole(role);
		}

		ModelAndView modelAndView = new ModelAndView();
		List<Role> roleList=userService.findAllRoles();
		modelAndView.addObject("roles", roleList);
		modelAndView.setViewName("roles");
		return modelAndView;
	}
}