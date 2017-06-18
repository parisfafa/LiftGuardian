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
import com.paris.backend.model.Role;
import com.paris.backend.model.User;
import com.paris.backend.service.DeviceMonitoringService;
import com.paris.backend.service.UserService;

@Controller
public class DeviceMonitoringController {
	
	@Autowired
	private DeviceMonitoringService deviceMonitoringService;
	
	
	@RequestMapping(value="/devices", method = RequestMethod.GET)
	public ModelAndView getDevices(){
		ModelAndView modelAndView = new ModelAndView();
		List<Device> devices=deviceMonitoringService.findAllDevices();

		modelAndView.addObject("devices", devices);

		modelAndView.setViewName("devices");
		return modelAndView;
	}
}