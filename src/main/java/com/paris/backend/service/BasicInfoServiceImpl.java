package com.paris.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;
import com.paris.backend.repository.ElevatorModelRepository;
import com.paris.backend.repository.ElevatorTypeRepository;
import com.paris.backend.repository.OrganizationRepository;

@Service("basicInfoService")
public class BasicInfoServiceImpl implements BasicInfoService{

	@Autowired
	private ElevatorModelRepository elevatorModelRepository;

	@Autowired
	private ElevatorTypeRepository elevatorTypeRepository;
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public List<ElevatorModel> findAllElevatorModel() {
		return elevatorModelRepository.findAll();
	}
	@Override
	public List<ElevatorType> findAllElevatorType() {
		return elevatorTypeRepository.findAll();
	}
	@Override
	public void deleteElevatorTypeById(int id) {
		elevatorTypeRepository.removeById(id);
		
	}
	@Override
	public void deleteElevatorModelById(int id) {
		elevatorModelRepository.removeById(id);
		
	}
	@Override
	public void editElevatorType(ElevatorType elevatorType) {
		//elevatorTypeRepository.updateElevatorType(elevatorType);		
	}
	
	@Override
	public void editElevatorModel(ElevatorModel elevatorModel) {
		//elevatorModelRepository.updateElevatorModel(elevatorModel);		
	}
	
	@Override
	public void saveElevatorModel(ElevatorModel elevatorModel) {
		elevatorModelRepository.save(elevatorModel);		
	}
	
	@Override
	public void saveElevatorType(ElevatorType elevatorModel) {
		elevatorTypeRepository.save(elevatorModel);		
	}

}