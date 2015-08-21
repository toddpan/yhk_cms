package com.ykh.dao.conference.domain;

import javax.persistence.*;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
@Table
@Entity
public class ConferenceSeed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seed;
    private Integer confId;
    private String conferenceName;
    private Integer applicationId;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public ConferenceSeed(Integer confId, Integer applicationId,String conferenceName) {
        this.confId = confId;
        this.applicationId=applicationId;
        this.conferenceName = conferenceName;
    }

    public ConferenceSeed() {
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public Integer getConfId() {
        return confId;
    }

    public void setConfId(Integer confId) {
        this.confId = confId;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }
}
