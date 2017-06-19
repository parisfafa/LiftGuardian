package com.paris.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.paris.backend.model.Device;
import com.paris.backend.model.Record;
import com.paris.backend.service.DeviceMonitoringService;

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
	@RequestMapping(value="/deviceStatus", method = RequestMethod.GET)
	public ModelAndView getDeviceStatus(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String id=request.getParameter("id");
		List<Record> record=deviceMonitoringService.findRecordById(id);
		System.out.println("fafa record"+record.size()+record.get(0).getElevatorStatus().getFloor());
		modelAndView.addObject("record", record);

		modelAndView.setViewName("status");
		return modelAndView;
	}
}