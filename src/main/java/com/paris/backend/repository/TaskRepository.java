package com.paris.backend.repository;

import com.paris.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Integer> {


   @Query(value="SELECT t.`taskid` FROM task AS t,device AS d,device_task AS dt  WHERE d.deviceid=?1 AND dt.deviceid=d.deviceid AND t.taskid=dt.taskid",nativeQuery = true)
   List<Integer> findByDeviceid(int deviceid);

   //@Query(value = "SELECT * FROM task where status =?1 and task_type =?2" ,nativeQuery = true)
   //List<Task> findTasksByStatusAndTask_type(int status,int task_type);

   //@Query(value = "SELECT * FROM task where start_time =?1 and task_type =?2" ,nativeQuery = true)
   //List<Task> findTasksByStart_timeAndTask_type(String start_time,int task_type);

   //@Query(value = "SELECT * FROM task where start_time =?1 and task_type =?2 and status =?3" ,nativeQuery = true)
   //List<Task> findTasksByStart_timeAndTask_typeAndStatus(String start_time,int task_type,int status);


}
