package com.paris.backend.SecondaryRepository;

import java.util.List;

import com.paris.backend.secondaryModel.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("recordRepository")
public interface RecordRepository extends JpaRepository<Record, Integer>
{
	@Query("select e  from Record e JOIN e.elevatorStatus r where e.deviceid=?1  ORDER BY e.createtime desc")
	List<Record> findAllByDeviceid(String id);
}