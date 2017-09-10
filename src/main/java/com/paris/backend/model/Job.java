package com.paris.backend.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class Job {


    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="jobid")
    private int id;

    @Expose
    @Column(name="hoistway1_comment")
    private String hoistway1_comment;
    @Expose @Column(name="hoistway2_comment")
    private String hoistway2_comment;
    @Expose @Column(name="hoistway3_comment")
    private String hoistway3_comment;
    @Expose @Column(name="hoistway4_comment")
    private String hoistway4_comment;
    @Expose @Column(name="hoistway5_comment")
    private String hoistway5_comment;
    @Expose @Column(name="hoistway6_comment")
    private String hoistway6_comment;

    @Expose @Column(name="liftcar1_comment")
    private String liftcar1_comment;
    @Expose @Column(name="liftcar2_comment")
    private String liftcar2_comment;
    @Expose @Column(name="liftcar3_comment")
    private String liftcar3_comment;

    @Expose @Column(name="entrance1_comment")
    private String entrance1_comment;
    @Expose @Column(name="entrance2_comment")
    private String entrance2_comment;
    @Expose @Column(name="entrance3_comment")
    private String entrance3_comment;

    @Expose @Column(name="liftpit1_comment")
    private String liftpit1_comment;
    @Expose @Column(name="liftpit2_comment")
    private String liftpit2_comment;
    @Expose @Column(name="liftpit3_comment")
    private String liftpit3_comment;

    @Expose @Column(name="hoistway1_img_url")
    private String hoistway1_img_url;
    @Expose @Column(name="hoistway2_img_url")
    private String hoistway2_img_url;
    @Expose @Column(name="hoistway3_img_url")
    private String hoistway3_img_url;
    @Expose @Column(name="hoistway4_img_url")
    private String hoistway4_img_url;
    @Expose @Column(name="hoistway5_img_url")
    private String hoistway5_img_url;
    @Expose @Column(name="hoistway6_img_url")
    private String hoistway6_img_url;

    @Expose @Column(name="liftcar1_img_url")
    private String liftcar1_img_url;
    @Expose @Column(name="liftcar2_img_url")
    private String liftcar2_img_url;
    @Expose @Column(name="liftcar3_img_url")
    private String liftcar3_img_url;

    @Expose @Column(name="entrance1_img_url")
    private String entrance1_img_url;
    @Expose @Column(name="entrance2_img_url")
    private String entrance2_img_url;
    @Expose @Column(name="entrance3_img_url")
    private String entrance3_img_url;

    @Expose @Column(name="liftpit1_img_url")
    private String liftpit1_img_url;
    @Expose @Column(name="liftpit2_img_url")
    private String liftpit2_img_url;
    @Expose @Column(name="liftpit3_img_url")
    private String liftpit3_img_url;


    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval=true,fetch = FetchType.EAGER)
    @JoinTable(name = "task_job", joinColumns = @JoinColumn(name = "jobid"), inverseJoinColumns = @JoinColumn(name = "taskid"))
    private Task task;
    
    public int getId() {
        return id;
    }

    public String getHoistway1_comment() {
        return hoistway1_comment;
    }

    public String getHoistway2_comment() {
        return hoistway2_comment;
    }

    public String getHoistway3_comment() {
        return hoistway3_comment;
    }

    public String getHoistway4_comment() {
        return hoistway4_comment;
    }

    public String getHoistway5_comment() {
        return hoistway5_comment;
    }

    public String getHoistway6_comment() {
        return hoistway6_comment;
    }

    public String getLiftcar1_comment() {
        return liftcar1_comment;
    }

    public String getLiftcar2_comment() {
        return liftcar2_comment;
    }

    public String getLiftcar3_comment() {
        return liftcar3_comment;
    }

    public String getEntrance1_comment() {
        return entrance1_comment;
    }

    public String getEntrance2_comment() {
        return entrance2_comment;
    }

    public String getEntrance3_comment() {
        return entrance3_comment;
    }

    public String getLiftpit1_comment() {
        return liftpit1_comment;
    }

    public String getLiftpit2_comment() {
        return liftpit2_comment;
    }

    public String getLiftpit3_comment() {
        return liftpit3_comment;
    }

    public String getHoistway1_img_url() {
        return hoistway1_img_url;
    }

    public String getHoistway2_img_url() {
        return hoistway2_img_url;
    }

    public String getHoistway3_img_url() {
        return hoistway3_img_url;
    }

    public String getHoistway4_img_url() {
        return hoistway4_img_url;
    }

    public String getHoistway5_img_url() {
        return hoistway5_img_url;
    }

    public String getHoistway6_img_url() {
        return hoistway6_img_url;
    }

    public String getLiftcar1_img_url() {
        return liftcar1_img_url;
    }

    public String getLiftcar2_img_url() {
        return liftcar2_img_url;
    }

    public String getLiftcar3_img_url() {
        return liftcar3_img_url;
    }

    public String getEntrance1_img_url() {
        return entrance1_img_url;
    }

    public String getEntrance2_img_url() {
        return entrance2_img_url;
    }

    public String getEntrance3_img_url() {
        return entrance3_img_url;
    }

    public String getLiftpit1_img_url() {
        return liftpit1_img_url;
    }

    public String getLiftpit2_img_url() {
        return liftpit2_img_url;
    }

    public String getLiftpit3_img_url() {
        return liftpit3_img_url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHoistway1_comment(String hoistway1_comment) {
        this.hoistway1_comment = hoistway1_comment;
    }

    public void setHoistway2_comment(String hoistway2_comment) {
        this.hoistway2_comment = hoistway2_comment;
    }

    public void setHoistway3_comment(String hoistway3_comment) {
        this.hoistway3_comment = hoistway3_comment;
    }

    public void setHoistway4_comment(String hoistway4_comment) {
        this.hoistway4_comment = hoistway4_comment;
    }

    public void setHoistway5_comment(String hoistway5_comment) {
        this.hoistway5_comment = hoistway5_comment;
    }

    public void setHoistway6_comment(String hoistway6_comment) {
        this.hoistway6_comment = hoistway6_comment;
    }

    public void setLiftcar1_comment(String liftcar1_comment) {
        this.liftcar1_comment = liftcar1_comment;
    }

    public void setLiftcar2_comment(String liftcar2_comment) {
        this.liftcar2_comment = liftcar2_comment;
    }

    public void setLiftcar3_comment(String liftcar3_comment) {
        this.liftcar3_comment = liftcar3_comment;
    }

    public void setEntrance1_comment(String entrance1_comment) {
        this.entrance1_comment = entrance1_comment;
    }

    public void setEntrance2_comment(String entrance2_comment) {
        this.entrance2_comment = entrance2_comment;
    }

    public void setEntrance3_comment(String entrance3_comment) {
        this.entrance3_comment = entrance3_comment;
    }

    public void setLiftpit1_comment(String liftpit1_comment) {
        this.liftpit1_comment = liftpit1_comment;
    }

    public void setLiftpit2_comment(String liftpit2_comment) {
        this.liftpit2_comment = liftpit2_comment;
    }

    public void setLiftpit3_comment(String liftpit3_comment) {
        this.liftpit3_comment = liftpit3_comment;
    }

    public void setHoistway1_img_url(String hoistway1_img_url) {
        this.hoistway1_img_url = hoistway1_img_url;
    }

    public void setHoistway2_img_url(String hoistway2_img_url) {
        this.hoistway2_img_url = hoistway2_img_url;
    }

    public void setHoistway3_img_url(String hoistway3_img_url) {
        this.hoistway3_img_url = hoistway3_img_url;
    }

    public void setHoistway4_img_url(String hoistway4_img_url) {
        this.hoistway4_img_url = hoistway4_img_url;
    }

    public void setHoistway5_img_url(String hoistway5_img_url) {
        this.hoistway5_img_url = hoistway5_img_url;
    }

    public void setHoistway6_img_url(String hoistway6_img_url) {
        this.hoistway6_img_url = hoistway6_img_url;
    }

    public void setLiftcar1_img_url(String liftcar1_img_url) {
        this.liftcar1_img_url = liftcar1_img_url;
    }

    public void setLiftcar2_img_url(String liftcar2_img_url) {
        this.liftcar2_img_url = liftcar2_img_url;
    }

    public void setLiftcar3_img_url(String liftcar3_img_url) {
        this.liftcar3_img_url = liftcar3_img_url;
    }

    public void setEntrance1_img_url(String entrance1_img_url) {
        this.entrance1_img_url = entrance1_img_url;
    }

    public void setEntrance2_img_url(String entrance2_img_url) {
        this.entrance2_img_url = entrance2_img_url;
    }

    public void setEntrance3_img_url(String entrance3_img_url) {
        this.entrance3_img_url = entrance3_img_url;
    }

    public void setLiftpit1_img_url(String liftpit1_img_url) {
        this.liftpit1_img_url = liftpit1_img_url;
    }

    public void setLiftpit2_img_url(String liftpit2_img_url) {
        this.liftpit2_img_url = liftpit2_img_url;
    }

    public void setLiftpit3_img_url(String liftpit3_img_url) {
        this.liftpit3_img_url = liftpit3_img_url;
    }
}
