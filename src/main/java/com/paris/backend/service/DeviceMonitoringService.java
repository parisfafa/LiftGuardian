package com.paris.backend.service;

import java.util.List;

import com.paris.backend.model.Device;
import com.paris.backend.secondaryModel.Record;

public interface DeviceMonitoringService {

	public List<Device> findAllDevices();
	
	public List<Record> findRecordById(String id);
	
	public void saveDevice(Device device);

}