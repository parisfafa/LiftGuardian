package com.paris.backend.model;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Entity
@Table(name = "mtc_ipt_status")
public class MtcIptStatus {

    @Expose
    @Id
    @Digits(integer=10, fraction=0)
    @Min(value = 1)
    @Column(name="mtc_ipt_statusid")
    private int id;

    @Expose
    @Column(name="mtc_ipt_type")
    private int mtc_ipt_type;

    @Expose
    @Column(name="last_mtc_ipt_time")
    private String last_mtc_ipt_time;

    @Expose
    @Column(name="task_inperiod")
    private boolean task_inperiod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMtc_ipt_type() {
        return mtc_ipt_type;
    }

    public void setMtc_ipt_type(int mtc_ipt_type) {
        this.mtc_ipt_type = mtc_ipt_type;
    }

    public String getLast_mtc_ipt_time() {
        return last_mtc_ipt_time;
    }

    public void setLast_mtc_ipt_time(String last_mtc_ipt_time) {
        this.last_mtc_ipt_time = last_mtc_ipt_time;
    }

    public boolean isTask_inperiod() {
        return task_inperiod;
    }

    public void setTask_inperiod(boolean task_inperiod) {
        this.task_inperiod = task_inperiod;
    }
}
