package com.paris.backend.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Entity
@Table(name = "task")
public class Task {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="taskid")
    private int taskid;

    @Expose
    @Column(name="task_type")
    private int task_type;

    @Expose
    @Column(name="time")
    private String time;

    @Expose
    @Column(name="status")
    private int status;


    @Expose
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "device_task", joinColumns = @JoinColumn(name = "taskid"), inverseJoinColumns = @JoinColumn(name = "deviceid"))
    private Device device;

    @Expose
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "taskid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    private User user;

    @Expose
    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
    @JoinTable(name = "task_job", joinColumns = @JoinColumn(name = "taskid"), inverseJoinColumns = @JoinColumn(name = "jobid"))
    private Job job;

    public int getTaskid() {
        return taskid;
    }

    public int getTask_type() {
        return task_type;
    }

    public String getTime() {
        return time;
    }


    public Device getDevice() {
        return device;
    }

    public User getUser() {
       return user;
    }

    public Job getJob() {
        return job;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public void setTask_type(int task_type) {
        this.task_type = task_type;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public void setDevice(Device device) {
        this.device = device;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Task{");
        sb.append("taskid=").append(taskid);
        sb.append(", task_type=").append(task_type);
        sb.append(", time='").append(time).append('\'');
        sb.append(", status=").append(status);
        sb.append(", device=").append(device);
        //sb.append(", user=").append(user);
        sb.append(", job=").append(job);
        sb.append('}');
        return sb.toString();
    }
}
