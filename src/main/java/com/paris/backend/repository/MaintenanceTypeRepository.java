package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.MaintenanceType;

@Repository("maintenanceTypeRepository")
public interface MaintenanceTypeRepository extends JpaRepository<MaintenanceType, Integer>{

	@Transactional
	List<MaintenanceType> removeById(int id);

}