package com.paris.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.paris.backend.model.AlarmType;

@Repository("alarmTypeRepository")
public interface AlarmTypeRepository extends JpaRepository<AlarmType, Integer>{

	@Transactional
	List<AlarmType> removeById(int id);

}