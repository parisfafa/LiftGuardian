package com.paris.backend.service;

import java.util.List;

import com.paris.backend.model.Device;

public interface DeviceMonitoringService {

	public List<Device> findAllDevices();

}