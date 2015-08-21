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

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }
}
