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
import com.paris.backend.model.AlarmType;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.MaintenanceType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;
import com.paris.backend.service.BasicInfoService;

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
		List<Organization> organizations=basicInfoService.findAllOrganization();
		//List<OrganizationType> organizationTypes = Arrays.asList(OrganizationType.values());
		modelAndView.addObject("organizations", organizations);
		//modelAndView.addObject("organizationTypes", organizationTypes);
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
			ElevatorType elevatorType=new ElevatorType();
			elevatorType.setElevatorType(request.getParameter("elevatorType"));
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
			AlarmType alarmType=new AlarmType(request.getParameter("alarmType"));
			basicInfoService.saveAlarmType(alarmType);
		}
		List<AlarmType> alarmTypeList=basicInfoService.findAllAlarmType();
		modelAndView.addObject("alarmTypes", alarmTypeList);
		modelAndView.setViewName("alarmTypes");
		return modelAndView;
	}
	@RequestMapping(value="/editOrg", method = RequestMethod.GET)
	public ModelAndView editOrganization(WebRequest request){
		ModelAndView modelAndView = new ModelAndView();
	
		String id=request.getParameter("id");

		List<Organization> device=basicInfoService.findOrganizationById(Integer.parseInt(id));
		modelAndView.addObject("organization", device.get(0));
		modelAndView.setViewName("editOrg");
		return modelAndView;
	}
	@RequestMapping(value = "/editOrg", method = RequestMethod.POST)
	public ModelAndView editOrg(@Valid Organization organization, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editOrg");
		} else {

			basicInfoService.saveOrganization(organization);
			modelAndView.addObject("successMessage", "Organization has been updated successfully");
			List<Organization> Organizations=basicInfoService.findAllOrganization();
			modelAndView.addObject("organizations", Organizations);
			modelAndView.setViewName("organizations");
			return modelAndView;
			
		}
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
			ElevatorModel elevatorModel=new ElevatorModel();
			elevatorModel.setElevatorModel(request.getParameter("elevatorModel"));
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
	
	@RequestMapping(value="/maintenanceTypes", method = RequestMethod.GET)
	public ModelAndView getMaintenanceTypes(){
		ModelAndView modelAndView = new ModelAndView();
		List<MaintenanceType> maintenanceTypes=basicInfoService.findAllMaintenanceType();
		modelAndView.addObject("maintenanceTypes", maintenanceTypes);
		modelAndView.setViewName("maintenanceTypes");
		return modelAndView;
	}
	
	@RequestMapping(value="/newOrganization", method = RequestMethod.GET)
	public ModelAndView newOrganization(){
		ModelAndView modelAndView = new ModelAndView();
		List<OrganizationType> organizationTypes = Arrays.asList(OrganizationType.values());
		modelAndView.addObject("organizationTypes", organizationTypes);

		Organization organization = new Organization();
		modelAndView.addObject("organization", organization);
		modelAndView.setViewName("newOrganization");
		return modelAndView;
	}
	
	@RequestMapping(value = "/newOrganization", method = RequestMethod.POST)
	public ModelAndView newOrganization(@Valid Organization organization, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		List<OrganizationType> organizationTypes = Arrays.asList(OrganizationType.values());
		modelAndView.addObject("organizationTypes", organizationTypes);
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("newOrganization");
		} else {

			basicInfoService.saveOrganization(organization);
			modelAndView.addObject("successMessage", "Organization has been added successfully");
			List<Organization> Organizations=basicInfoService.findAllOrganization();
			modelAndView.addObject("organizations", Organizations);
			modelAndView.setViewName("organizations");
			return modelAndView;
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/newManufacturer", method = RequestMethod.GET)
	public ModelAndView newManufacturer(){
		ModelAndView modelAndView = new ModelAndView();

		Manufacturer manufacturer = new Manufacturer();
		modelAndView.addObject("manufacturer", manufacturer);
		modelAndView.setViewName("newManufacturer");
		return modelAndView;
	}
	
	@RequestMapping(value = "/newManufacturer", method = RequestMethod.POST)
	public ModelAndView newManufacturer(@Valid Manufacturer manufacturer, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("newOrganization");
		} else {

			basicInfoService.saveManufacturer(manufacturer);
			modelAndView.addObject("successMessage", "Manufacturer has been added successfully");
			List<Manufacturer> manufacturers=basicInfoService.findAllManufacturer();
			modelAndView.addObject("manufacturers", manufacturers);
			modelAndView.setViewName("manufacturers");
			return modelAndView;
			
		}
		return modelAndView;
	}
}