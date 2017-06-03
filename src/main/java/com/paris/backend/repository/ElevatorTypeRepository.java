package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.ElevatorType;

@Repository("elevatorTypeRepository")
public interface ElevatorTypeRepository extends JpaRepository<ElevatorType, Integer>{

	@Transactional
	List<ElevatorType> removeById(int id);
	/*@Transactional
	void updateElevatorType(ElevatorType elevatorType);*/
}