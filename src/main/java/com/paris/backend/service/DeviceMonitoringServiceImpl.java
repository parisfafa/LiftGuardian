package com.paris.backend.service;

import java.util.List;

import com.paris.backend.model.Camera;
import com.paris.backend.repository.CameraRepository;
import com.paris.backend.secondaryModel.ElevatorStatus;
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

	@Autowired
	private CameraRepository cameraRepository;
	@Override
	public List<Device> findAllDevices() {
		return deviceRepository.findAll();
	}

	@Override
	public List<ElevatorStatus> findRecordById(String id) {
		return recordRepository.findAllByDeviceid(id);

	}

	@Override
	public void saveDevice(Device device) {
		deviceRepository.save(device);
		
	}

	@Override
	public List<Device> findDeviceById(Long id) {
		return deviceRepository.findDeviceById(id);
	}



	@Override
	public List<Camera> findAllCameras() {
		return cameraRepository.findAll();
	}


	@Override
	public void saveCamera(Camera camera) {
		cameraRepository.save(camera);

	}

	@Override
	public List<Camera> findCameraById(int id) {
		return cameraRepository.findCameraById(id);

	}
	@Override
	public void deleteDeviceById(int id) {
		deviceRepository.removeById(id);
		

	}

}
