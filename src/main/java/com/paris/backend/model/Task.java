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
    @Digits(integer=10, fraction=0)
    @Min(value = 1)
    @Column(name="taskid")
    private Long taskid;

    @Expose
    @Column(name="task_type")
    private String task_type;

    @Expose
    @Column(name="time")
    private String time;

    @Expose
    @Column(name="deviceid")
    private String postcode;

    @Expose
    @Column(name="status")
    private String status;

    @Expose
    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
    @JoinTable(name = "device_task", joinColumns = @JoinColumn(name = "taskid"), inverseJoinColumns = @JoinColumn(name = "deviceid"))
    private Device device;

    @Expose
    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "taskid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    private User user;

    @Expose
    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
    @JoinTable(name = "task_job", joinColumns = @JoinColumn(name = "taskid"), inverseJoinColumns = @JoinColumn(name = "jobid"))
    private Job job;

    public Long getTaskid() {
        return taskid;
    }

    public String getTask_type() {
        return task_type;
    }

    public String getTime() {
        return time;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStatus() {
        return status;
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

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
