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

import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
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
	@RequestMapping(value="/elevatorModels", method = RequestMethod.GET)
	public ModelAndView getElevatorModels(){
		ModelAndView modelAndView = new ModelAndView();
		List<ElevatorModel> elevatorModelList=basicInfoService.findAllElevatorModel();
		modelAndView.addObject("elevatorModels", elevatorModelList);
		modelAndView.setViewName("elevatorModels");
		return modelAndView;
	}
	
	@RequestMapping(value="/editElevatorTypes", method = RequestMethod.GET)
	public ModelAndView editElevatorTypes(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			basicInfoService.deleteElevatorTypeById(id);
		}
		List<ElevatorType> elevatorTypeList=basicInfoService.findAllElevatorType();
		modelAndView.addObject("elevatorTypes", elevatorTypeList);
		modelAndView.setViewName("elevatorTypes");
		return modelAndView;
	}
	@RequestMapping(value="/editElevatorModels", method = RequestMethod.GET)
	public ModelAndView editElevatorModels(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
		if("del".equals(request.getParameter("oper"))){
			int id=Integer.parseInt(request.getParameter("id"));
			basicInfoService.deleteElevatorModelById(id);
		}
		List<ElevatorModel> elevatorModelList=basicInfoService.findAllElevatorModel();
		modelAndView.addObject("elevatorModels", elevatorModelList);
		modelAndView.setViewName("elevatorModels");
		return modelAndView;
	}

}