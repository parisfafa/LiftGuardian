package com.paris.backend.SecondaryRepository;

import java.util.List;

import com.paris.backend.secondaryModel.ElevatorStatus;
import com.paris.backend.secondaryModel.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("recordRepository")
public interface RecordRepository extends JpaRepository<ElevatorStatus, Integer>
{
	//@Query(value="SELECT  *  FROM tb_record e JOIN tb_elevatorStatus r WHERE deviceid=?1  ORDER BY e.createtime DESC LIMIT 1" , nativeQuery = true)
	@Query(value="SELECT  *  FROM  tb_elevatorStatus  WHERE rtuid=?1 order by datatime desc LIMIT 1",nativeQuery = true)
	List<ElevatorStatus> findAllByDeviceid(String id);



}