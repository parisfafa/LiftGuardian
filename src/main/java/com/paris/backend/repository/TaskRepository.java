package com.paris.backend.repository;

import com.paris.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Integer> {

   @Query(value="SELECT  *  FROM  task  WHERE userid=?1 ",nativeQuery = true)
   List<Task> findByUserid(String userid);

   @Query(value="SELECT  *  FROM  task  WHERE device=?1 ",nativeQuery = true)
   List<Task> findByDeviceid(String deviceid);

   List<Task> findByStatus(int status);

}
