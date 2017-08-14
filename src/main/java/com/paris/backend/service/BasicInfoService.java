package com.paris.backend.service;

import java.util.List;

import com.paris.backend.model.AlarmType;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.MaintenanceType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;

public interface BasicInfoService {
	public List<ElevatorModel> findAllElevatorModel();
	public List<Organization> findAllOrganization();
	public List<Organization> findOrganizationById(int id);
	public List<ElevatorType> findAllElevatorType();
	public List<AlarmType> findAllAlarmType();
	public List<Manufacturer> findAllManufacturer();
	public List<MaintenanceType> findAllMaintenanceType();
	public void deleteElevatorTypeById(int id);
	public void deleteElevatorModelById(int id);
	public void deleteOrganizationById(int id);
	public void deleteAlarmTypeById(int id);
	public void deleteManufacturerById(int id);
	public void deleteMaintenanceTypeById(int id);
	public void editElevatorType(ElevatorType elevatorType);
	public void editElevatorModel(ElevatorModel elevatorModel);
	public void saveElevatorModel(ElevatorModel elevatorModel);
	public void saveElevatorType(ElevatorType elevatorModel);
	public void saveAlarmType(AlarmType alarmType);
	public void saveOrganization(Organization organization);
	public void saveManufacturer(Manufacturer manufacturer);
	public void saveMaintenanceType(MaintenanceType maintenanceType);
}