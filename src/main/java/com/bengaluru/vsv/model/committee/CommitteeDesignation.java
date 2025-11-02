package com.bengaluru.vsv.model.committee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "committe_designation")
@Getter
@Setter
public class CommitteeDesignation {

    @Id
    @Column(name = "com_desgn_id")
    private int comDesgnId;

    @Column(name = "designation_desc")
    private String designationDesc;

    @Column(name = "rank")
    private int rank;
}
