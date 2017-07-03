package com.paris.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paris.backend.model.AlarmType;
import com.paris.backend.model.Device;
import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorStatus;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.model.MaintenanceType;
import com.paris.backend.model.Manufacturer;
import com.paris.backend.model.Organization;
import com.paris.backend.model.Record;
import com.paris.backend.repository.AlarmTypeRepository;
import com.paris.backend.repository.DeviceRepository;
import com.paris.backend.repository.ElevatorModelRepository;
import com.paris.backend.repository.ElevatorTypeRepository;
import com.paris.backend.repository.MaintenanceTypeRepository;
import com.paris.backend.repository.ManufacturerRepository;
import com.paris.backend.repository.OrganizationRepository;
import com.paris.backend.repository.RecordRepository;

@Service("deviceMonitoringService")
public class DeviceMonitoringServiceImpl implements DeviceMonitoringService{

	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	private RecordRepository recordRepository;
	
	@Override
	public List<Device> findAllDevices() {
		return deviceRepository.findAll();
	}

	@Override
	public List<Record> findRecordById(String id) {
		return recordRepository.findAllByDeviceid(id);
		 
	}

	@Override
	public void saveDevice(Device device) {
		deviceRepository.save(device);
		
	}

}