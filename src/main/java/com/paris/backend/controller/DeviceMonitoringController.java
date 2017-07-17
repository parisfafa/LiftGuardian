package com.paris.backend.controller;
import java.util.List;

import javax.validation.Valid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.paris.backend.model.*;
import com.paris.backend.secondaryModel.ElevatorStatus;
import com.paris.backend.secondaryModel.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

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

		System.out.println(devices.get(0).getCamera().getUrl()+"url");
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
		List<Camera> cameras=deviceMonitoringService.findAllCameras();
		modelAndView.addObject("cameras", cameras);
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
		List<Camera> cameras=deviceMonitoringService.findAllCameras();
		modelAndView.addObject("cameras", cameras);

		String id=request.getParameter("id");

		List<Device> device=deviceMonitoringService.findDeviceById(Long.parseLong(id));
		modelAndView.addObject("device", device.get(0));
		modelAndView.setViewName("editDevice");
		return modelAndView;
	}

	@RequestMapping(value="/deleteDevice", method = RequestMethod.POST)
	public ModelAndView deleteDevice(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String id=request.getParameter("id");

		deviceMonitoringService.deleteDeviceById(Integer.parseInt(id));
		List<Device> devices=deviceMonitoringService.findAllDevices();
		modelAndView.addObject("devices", devices);
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

		List<Record> record=deviceMonitoringService.findRecordById(id);
		System.out.println("dada"+id+Long.valueOf(id)+device.size()+device.get(0).getCountry());
		modelAndView.addObject("record", record.isEmpty()?null:record.get(0));

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

	@RequestMapping(value="/newCamera", method = RequestMethod.GET)
	public ModelAndView newCamera(){
		ModelAndView modelAndView = new ModelAndView();
		Camera camera = new Camera();
		modelAndView.addObject("camera", camera);
		modelAndView.setViewName("newCamera");
		return modelAndView;
	}

	@RequestMapping(value = "/newCamera", method = RequestMethod.POST)
	public ModelAndView newCamera(@Valid Camera camera, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("newCamera");
		} else {
			deviceMonitoringService.saveCamera(camera);
			modelAndView.addObject("successMessage", "Camera has been added successfully");
			List<Camera> cameras=deviceMonitoringService.findAllCameras();
			modelAndView.addObject("cameras", cameras);
			modelAndView.setViewName("cameras");
			return modelAndView;

		}
		return modelAndView;
	}

	@RequestMapping(value="/editCamera", method = RequestMethod.GET)
	public ModelAndView editCamera(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String id=request.getParameter("id");
		System.out.println(id);
		List<Camera> cameras=deviceMonitoringService.findCameraById(Long.parseLong(id));
		modelAndView.addObject("camera", cameras.get(0));
		modelAndView.setViewName("editCamera");
		return modelAndView;
	}

	@RequestMapping(value = "/editCamera", method = RequestMethod.POST)
	public ModelAndView editCamera(@Valid Camera camera, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editDevice");
		} else {
			deviceMonitoringService.saveCamera(camera);
			modelAndView.addObject("successMessage", "Camera has been added successfully");
			List<Camera> cameras=deviceMonitoringService.findAllCameras();
			modelAndView.addObject("cameras", cameras);
			modelAndView.setViewName("cameras");
			return modelAndView;

		}
		return modelAndView;
	}

	@RequestMapping(value="/cameras", method = RequestMethod.GET)
	public ModelAndView getCameras(){
		ModelAndView modelAndView = new ModelAndView();
		List<Camera> cameras=deviceMonitoringService.findAllCameras();

		modelAndView.addObject("cameras", cameras);

		modelAndView.setViewName("cameras");

		return modelAndView;
	}
}