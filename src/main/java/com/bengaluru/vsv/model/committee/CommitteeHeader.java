package com.bengaluru.vsv.model.committee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "committe_header")
@Getter
@Setter
public class CommitteeHeader {
    @Id
    @Column(name = "committe_id", nullable = false)
    private int committeeId;

    @Column(name = "committe_year")
    private Integer committeYear;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
