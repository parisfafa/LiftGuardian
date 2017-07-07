package com.paris.backend.service;

import java.util.List;

import com.paris.backend.secondaryModel.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paris.backend.model.Device;
import com.paris.backend.repository.DeviceRepository;
import com.paris.backend.SecondaryRepository.RecordRepository;

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