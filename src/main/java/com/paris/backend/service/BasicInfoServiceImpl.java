package com.paris.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paris.backend.model.AlarmType;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.MaintenanceType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;
import com.paris.backend.repository.AlarmTypeRepository;
import com.paris.backend.repository.ElevatorModelRepository;
import com.paris.backend.repository.ElevatorTypeRepository;
import com.paris.backend.repository.MaintenanceTypeRepository;
import com.paris.backend.repository.ManufacturerRepository;
import com.paris.backend.repository.OrganizationRepository;

@Service("basicInfoService")
public class BasicInfoServiceImpl implements BasicInfoService{

	@Autowired
	private ElevatorModelRepository elevatorModelRepository;

	@Autowired
	private ElevatorTypeRepository elevatorTypeRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private AlarmTypeRepository alarmTypeRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@Autowired
	private MaintenanceTypeRepository maintenanceTypeRepository;
	
	@Override
	public List<ElevatorModel> findAllElevatorModel() {
		return elevatorModelRepository.findAll();
	}
	@Override
	public List<ElevatorType> findAllElevatorType() {
		return elevatorTypeRepository.findAll();
	}
	@Override
	public void deleteElevatorTypeById(int id) {
		elevatorTypeRepository.removeById(id);
		
	}
	@Override
	public void deleteElevatorModelById(int id) {
		elevatorModelRepository.removeById(id);
		
	}
	
	@Override
	public void editElevatorType(ElevatorType elevatorType) {
		//elevatorTypeRepository.updateElevatorType(elevatorType);		
	}
	
	@Override
	public void editElevatorModel(ElevatorModel elevatorModel) {
		//elevatorModelRepository.updateElevatorModel(elevatorModel);		
	}
	
	@Override
	public void saveElevatorModel(ElevatorModel elevatorModel) {
		elevatorModelRepository.save(elevatorModel);		
	}
	
	@Override
	public void saveElevatorType(ElevatorType elevatorModel) {
		elevatorTypeRepository.save(elevatorModel);		
	}
	@Override
	public List<Organization> findAllOrganization() {
		return organizationRepository.findAll();
	}
	@Override
	public void deleteOrganizationById(int id) {
		organizationRepository.removeById(id);
		
	}
	@Override
	public List<AlarmType> findAllAlarmType() {
		return this.alarmTypeRepository.findAll();
	}
	@Override
	public void deleteAlarmTypeById(int id) {
		alarmTypeRepository.removeById(id);		
	}
	@Override
	public void saveAlarmType(AlarmType alarmType) {
		alarmTypeRepository.save(alarmType)	;	
	}
	@Override
	public void saveOrganization(Organization organization) {
		this.organizationRepository.save(organization);
		
	}
	@Override
	public List<Manufacturer> findAllManufacturer() {
		return manufacturerRepository.findAll();
	}
	@Override
	public void deleteManufacturerById(int id) {
		manufacturerRepository.removeById(id);
		
	}
	@Override
	public void saveManufacturer(Manufacturer manufacturer) {
		manufacturerRepository.save(manufacturer);
		
	}
	@Override
	public List<MaintenanceType> findAllMaintenanceType() {
		return this.maintenanceTypeRepository.findAll();
	}
	@Override
	public void deleteMaintenanceTypeById(int id) {
		maintenanceTypeRepository.removeById(id);
		
	}
	
	@Override
	public void saveMaintenanceType(MaintenanceType maintenanceType) {
		maintenanceTypeRepository.save(maintenanceType);
		
	}
	@Override
	public List<Organization> findOrganizationById(int id) {
		return organizationRepository.findOrganizationById(id);
	}
}