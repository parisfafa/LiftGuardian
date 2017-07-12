package com.paris.backend.controller;
import java.util.List;

import javax.validation.Valid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paris.backend.secondaryModel.ElevatorStatus;
import com.paris.backend.secondaryModel.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.paris.backend.model.Device;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;
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
	
	@RequestMapping(value="/editDevice", method = RequestMethod.GET)
	public ModelAndView editDevice(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		List<ElevatorType> elevatorTypes = basicInfoService.findAllElevatorType();
		modelAndView.addObject("elevatorTypes", elevatorTypes);
		List<ElevatorModel> elevatorModels=basicInfoService.findAllElevatorModel();
		modelAndView.addObject("elevatorModels", elevatorModels);
		List<Manufacturer> manufacturers=basicInfoService.findAllManufacturer();
		modelAndView.addObject("manufacturers", manufacturers);	
		List<Organization> organizations=basicInfoService.findAllOrganization();
		modelAndView.addObject("organizations", organizations);	
		String id=request.getParameter("id");

		List<Device> device=deviceMonitoringService.findDeviceById(Long.parseLong(id));
		modelAndView.addObject("device", device.get(0));
		modelAndView.setViewName("editDevice");
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
	@RequestMapping(value = "/editDevice", method = RequestMethod.POST)
	public ModelAndView editDevice(@Valid Device device, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editDevice");
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

		List<Device> device=deviceMonitoringService.findDeviceById(Long.parseLong(id));
		//List<ElevatorStatus> record=deviceMonitoringService.findRecordById(id);
		System.out.println("dada"+id+Long.valueOf(id)+device.size()+device.get(0).getCountry());
		//modelAndView.addObject("record", record.isEmpty()?null:record.get(0));
		modelAndView.addObject("device",device.get(0));
		modelAndView.setViewName("status");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value="/refreshDeviceStatus", method = RequestMethod.GET)
	public String refreshDeviceStatus(WebRequest request)
	{
		String id = request.getParameter("id");
		if(id.length()<8)
		{
			int appendLen=8-id.length();
			for(int i=0; i<appendLen;i++)
			{
				id=0+id;
			}
		}
		List<ElevatorStatus> record = deviceMonitoringService.findRecordById(id);
		if(record.size()>0)
		{
			GsonBuilder gsonBuilder= new GsonBuilder();
			gsonBuilder.excludeFieldsWithoutExposeAnnotation();  //使用@Expose 忽略字段
			gsonBuilder.serializeNulls();    //序列化空值
			Gson gson=gsonBuilder.create();
			String jsonRecord=gson.toJson(record==null?null:record.get(0));
			System.out.println(jsonRecord);
			return jsonRecord;
		}
		return  null;
	}
}