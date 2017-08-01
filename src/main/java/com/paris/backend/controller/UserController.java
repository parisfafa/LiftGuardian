package com.paris.backend.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.paris.backend.model.Device;
import com.paris.backend.model.Organization;
import com.paris.backend.model.Role;
import com.paris.backend.model.User;
import com.paris.backend.service.BasicInfoService;
import com.paris.backend.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BasicInfoService basicInfoService;
	
	@RequestMapping(value="/deny", method = RequestMethod.GET)
	public ModelAndView getAccessDeniedPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deny");
		return modelAndView;
	}
	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public ModelAndView getAbout(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		return modelAndView;
	}
	@RequestMapping(value="/faq", method = RequestMethod.GET)
	public ModelAndView getFaQ(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("faq");
		return modelAndView;
	}
	@RequestMapping(value="/audit", method = RequestMethod.GET)
	public ModelAndView getAudit(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("audit");
		return modelAndView;
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ModelAndView getUsers(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> userList=userService.findAllUsers();
		List<Role> roleList=userService.findAllRoles();
		modelAndView.addObject("users", userList);
		modelAndView.addObject("roles", roleList);
		modelAndView.setViewName("users");
		return modelAndView;
	}
	@RequestMapping(value="/editUser", method = RequestMethod.POST)
	public ModelAndView editUserSubmit(@Valid User user, BindingResult bindingResult){
		
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles=userService.findAllRoles();
		List<Organization> organizations=basicInfoService.findAllOrganization();
		modelAndView.addObject("roles",roles);
		modelAndView.addObject("organizations",organizations);
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editUser");
		} else {

			userService.updateUser(user);
			modelAndView.addObject("successMessage", "User has been updated successfully");
			List<User> userList=userService.findAllUsers();
			modelAndView.addObject("users", userList);
			modelAndView.setViewName("users");
			
		}
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
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles=userService.findAllRoles();
		List<Organization> organizations=basicInfoService.findAllOrganization();
		modelAndView.addObject("roles",roles);
		modelAndView.addObject("organizations",organizations);
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	@RequestMapping(value="/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles=userService.findAllRoles();
		List<Organization> organizations=basicInfoService.findAllOrganization();
		modelAndView.addObject("roles",roles);
		modelAndView.addObject("organizations",organizations);
		String email=request.getParameter("email");
		User user = userService.findUserByEmail(email);
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("editUser");
		return modelAndView;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles=userService.findAllRoles();
		modelAndView.addObject("roles",roles);
		List<Organization> organizations=basicInfoService.findAllOrganization();

		modelAndView.addObject("organizations",organizations);
		User userExists = userService.findUserByEmail(user.getEmail());
		
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {

			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			List<User> userList=userService.findAllUsers();
			modelAndView.addObject("users", userList);
			modelAndView.setViewName("users");
			
		}
		return modelAndView;
	}
}