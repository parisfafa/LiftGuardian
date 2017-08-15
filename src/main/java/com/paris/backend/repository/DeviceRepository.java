package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.Device;



@Repository("deviceRepository")
public interface DeviceRepository extends JpaRepository<Device, Integer>{
	List<Device> findDeviceById(Long id);

	
	@Transactional
	List<Device> removeById(int id);

}