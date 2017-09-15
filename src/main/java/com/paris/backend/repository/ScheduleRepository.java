package com.paris.backend.repository;

import com.paris.backend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("scheduleRepository")
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(value = "SELECT * FROM Schedule as s,device as d,schedule_device as sd  WHERE d.deviceid=?1 and sd.deviceid=?1 and sd.scheduleid=s.scheduleid and schedule_type=?2 ORDER BY s.scheduleid DESC LIMIT 1", nativeQuery = true)
    public List<Schedule> findScheduleByDeviceAndSchedule_typeOrderByIdDesc(int deviceid, int schedule_type);
}
