package com.paris.backend.model;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Expose
    @Id
    @Digits(integer=10, fraction=0)
    @Min(value = 1)
    @Column(name="scheduleid")
    private int id;

    @Expose

    @Column(name="schedule_period")
    private int schedule_period;


    @Expose

    @Column(name="schedule_type")
    private int schedule_type;

    @Expose

    @Column(name="notice_period")
    private int notice_period;

    @Expose
    @Column(name="task_inperiod")
    private boolean task_inperiod;

    @Expose
    @Column(name="last_mtc_ipt_time")
    private String last_mtc_ipt_time;

    @Expose
    @Column(name="status")
    private int status;


    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
    @JoinTable(name = "schedule_device", joinColumns = @JoinColumn(name = "scheduleid"), inverseJoinColumns = @JoinColumn(name = "deviceid"))
    private Device device;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchedule_period() {
        return schedule_period;
    }

    public void setSchedule_period(int schedule_period) {
        this.schedule_period = schedule_period;
    }


    public int getSchedule_type() {
        return schedule_type;
    }

    public void setSchedule_type(int schedule_type) {
        this.schedule_type = schedule_type;
    }

    public int getNotice_period() {
        return notice_period;
    }

    public void setNotice_period(int notice_period) {
        this.notice_period = notice_period;
    }

    public boolean getTask_inperiod() {
        return task_inperiod;
    }

    public void setTask_inperiod(boolean task_inperiod) {
        this.task_inperiod = task_inperiod;
    }

    public String getLast_mtc_ipt_time() {
        return last_mtc_ipt_time;
    }

    public void setLast_mtc_ipt_time(String last_mtc_ipt_time) {
        this.last_mtc_ipt_time = last_mtc_ipt_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
