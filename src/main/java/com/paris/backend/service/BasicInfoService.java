package com.paris.backend.service;

import java.util.List;

import com.paris.backend.model.ElevatorModel;
import com.paris.backend.model.ElevatorType;

public interface BasicInfoService {
	public List<ElevatorModel> findAllElevatorModel();
	public List<ElevatorType> findAllElevatorType();
	public void deleteElevatorTypeById(int id);
	public void deleteElevatorModelById(int id);
	public void editElevatorType(ElevatorType elevatorType);
	public void editElevatorModel(ElevatorModel elevatorModel);
	public void saveElevatorModel(ElevatorModel elevatorModel);
	public void saveElevatorType(ElevatorType elevatorModel);
}