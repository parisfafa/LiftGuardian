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

import com.paris.backend.model.AlarmType;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;
import com.paris.backend.model.Role;
import com.paris.backend.model.User;
import com.paris.backend.service.BasicInfoService;
import com.paris.backend.service.UserService;

@Controller
public class BasicInfoController {
	
	@Autowired
	private BasicInfoService basicInfoService;
	
	
	@RequestMapping(value="/elevatorTypes", method = RequestMethod.GET)
	public ModelAndView getElevatorTypes(){
		ModelAndView modelAndView = new ModelAndView();
		List<ElevatorType> elevatorTypeList=basicInfoService.findAllElevatorType();
		modelAndView.addObject("elevatorTypes", elevatorTypeList);

		modelAndView.setViewName("elevatorTypes");
		return modelAndView;
	}
	@RequestMapping(value="/organizations", method = RequestMethod.GET)
	public ModelAndView getOrganizations(){
		ModelAndView modelAndView = new ModelAndView();
		List<Organization> organizationList=basicInfoService.findAllOrganization();
		modelAndView.addObject("organizations", organizationList);
		modelAndView.setViewName("organizations");
		return modelAndView;
	}
	@RequestMapping(value="/alarmTypes", method = RequestMethod.GET)
	public ModelAndView getAlarmTypes(){
		ModelAndView modelAndView = new ModelAndView();
		List<AlarmType> alarmTypeList=basicInfoService.findAllAlarmType();
		modelAndView.addObject("alarmTypes", alarmTypeList);
		modelAndView.setViewName("alarmTypes");
		return modelAndView;
	}
	@RequestMapping(value="/elevatorModels", method = RequestMethod.GET)
	public ModelAndView getElevatorModels(){
		ModelAndView modelAndView = new ModelAndView();
		List<ElevatorModel> elevatorModelList=basicInfoService.findAllElevatorModel();
		modelAndView.addObject("elevatorModels", elevatorModelList);
		modelAndView.setViewName("elevatorModels");
		return modelAndView;
	}
	
	@RequestMapping(value="/editElevatorType", method = RequestMethod.POST)
	public ModelAndView editElevatorTypes(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			basicInfoService.deleteElevatorTypeById(id);
		}
		if("add".equals(request.getParameter("oper"))){
			ElevatorType elevatorType=new ElevatorType(request.getParameter("elevatorType"));
			basicInfoService.saveElevatorType(elevatorType);
		}
		List<ElevatorType> elevatorTypeList=basicInfoService.findAllElevatorType();
		modelAndView.addObject("elevatorTypes", elevatorTypeList);
		modelAndView.setViewName("elevatorTypes");
		return modelAndView;
	}
	@RequestMapping(value="/editAlarmType", method = RequestMethod.POST)
	public ModelAndView editAlarmTypes(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			basicInfoService.deleteAlarmTypeById(id);
		}
		if("add".equals(request.getParameter("oper"))){
			AlarmType alarmType=new AlarmType(request.getParameter("elevatorType"));
			basicInfoService.saveAlarmType(alarmType);
		}
		List<AlarmType> alarmTypeList=basicInfoService.findAllAlarmType();
		modelAndView.addObject("alarmTypes", alarmTypeList);
		modelAndView.setViewName("alarmTypes");
		return modelAndView;
	}
	@RequestMapping(value="/editOrganization", method = RequestMethod.POST)
	public ModelAndView editOrganization(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			basicInfoService.deleteOrganizationById(id);
		}
		if("add".equals(request.getParameter("oper"))){
			Organization organization=new Organization();
			basicInfoService.saveOrganization(organization);
		}
		List<Organization> Organizations=basicInfoService.findAllOrganization();
		modelAndView.addObject("organizations", Organizations);
		modelAndView.setViewName("organizations");
		return modelAndView;
	}
	@RequestMapping(value="/editElevatorModel", method = RequestMethod.POST)
	public ModelAndView editElevatorModels(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			basicInfoService.deleteElevatorModelById(id);
		}
		if("add".equals(request.getParameter("oper"))){
			ElevatorModel elevatorModel=new ElevatorModel(request.getParameter("elevatorModel"));
			basicInfoService.saveElevatorModel(elevatorModel);
		}
		List<ElevatorModel> elevatorModelList=basicInfoService.findAllElevatorModel();
		modelAndView.addObject("elevatorModels", elevatorModelList);
		modelAndView.setViewName("elevatorModels");
		return modelAndView;
	}
	@RequestMapping(value="/manufacturers", method = RequestMethod.GET)
	public ModelAndView getManufacturers(){
		ModelAndView modelAndView = new ModelAndView();
		List<Manufacturer> manufacturers=basicInfoService.findAllManufacturer();
		modelAndView.addObject("manufacturers", manufacturers);
		modelAndView.setViewName("manufacturers");
		return modelAndView;
	}
}