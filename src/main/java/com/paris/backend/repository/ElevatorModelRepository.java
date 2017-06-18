package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.ElevatorModel;

@Repository("elevatorModelRepository")
@Transactional(value = "transactionManager")
public interface ElevatorModelRepository extends JpaRepository<ElevatorModel, Integer>{

	@Transactional
	List<ElevatorModel> removeById(int id);
	
	/*@Transactional
	void updateElevatorModel(ElevatorModel elevatorModel);*/
}