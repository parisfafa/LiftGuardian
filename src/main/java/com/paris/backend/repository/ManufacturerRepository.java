package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.AlarmType;
import com.paris.backend.model.Manufacturer;

@Repository("manufacturerRepository")
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{

	@Transactional
	List<Manufacturer> removeById(int id);

}