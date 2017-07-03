package com.paris.backend.controller;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.paris.backend.constants.OrganizationType;
import com.paris.backend.model.Device;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;
import com.paris.backend.model.Record;
import com.paris.backend.service.BasicInfoService;
import com.paris.backend.service.DeviceMonitoringService;

@Controller
public class DeviceMonitoringController {
	
	@Autowired
	private DeviceMonitoringService deviceMonitoringService;
	@Autowired
	private BasicInfoService basicInfoService;
	
	@RequestMapping(value="/devices", method = RequestMethod.GET)
	public ModelAndView getDevices(){
		ModelAndView modelAndView = new ModelAndView();
		List<Device> devices=deviceMonitoringService.findAllDevices();

		modelAndView.addObject("devices", devices);

		modelAndView.setViewName("devices");
		return modelAndView;
	}
	
	@RequestMapping(value="/newDevice", method = RequestMethod.GET)
	public ModelAndView newDevice(){
		ModelAndView modelAndView = new ModelAndView();
		List<ElevatorType> elevatorTypes = basicInfoService.findAllElevatorType();
		modelAndView.addObject("elevatorTypes", elevatorTypes);
		List<ElevatorModel> elevatorModels=basicInfoService.findAllElevatorModel();
		modelAndView.addObject("elevatorModels", elevatorModels);
		List<Manufacturer> manufacturers=basicInfoService.findAllManufacturer();
		modelAndView.addObject("manufacturers", manufacturers);	
		List<Organization> organizations=basicInfoService.findAllOrganization();
		modelAndView.addObject("organizations", organizations);	
		Device device = new Device();
		modelAndView.addObject("device", device);
		modelAndView.setViewName("newDevice");
		return modelAndView;
	}
	@RequestMapping(value = "/newDevice", method = RequestMethod.POST)
	public ModelAndView newDevice(@Valid Device device, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("newDevice");
		} else {
			deviceMonitoringService.saveDevice(device);
			modelAndView.addObject("successMessage", "Device has been added successfully");
			List<Device> devices=deviceMonitoringService.findAllDevices();
			modelAndView.addObject("devices", devices);
			modelAndView.setViewName("devices");
			return modelAndView;
			
		}
		return modelAndView;
	}
	@RequestMapping(value="/deviceStatus", method = RequestMethod.GET)
	public ModelAndView getDeviceStatus(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String id=request.getParameter("id");
		List<Record> record=deviceMonitoringService.findRecordById(id);

		modelAndView.addObject("record", record==null?null:record.get(0));

		modelAndView.setViewName("status");
		return modelAndView;
	}
}