package com.bengaluru.vsv.model.committee;

import com.bengaluru.vsv.model.VsvMemberMaster;
import com.bengaluru.vsv.model.keys.CommitteDetailsKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "committe_details")
@Getter
@Setter
public class VsvCommitteeDetails implements Serializable {

    @EmbeddedId
    private CommitteDetailsKey committeDetailsKey;

    @Column(name = "member_name", length = 45)
    private String memberName;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    // 🔗 Mapping to vsv_member_master via vsv_id
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "vsv_id", insertable = false, updatable = false)
    @JsonBackReference
    @NotFound(action = NotFoundAction.IGNORE)
    private VsvMemberMaster memberMaster;

    @ManyToOne
    @JoinColumn(name = "committe_id", referencedColumnName = "committe_id", insertable = false, updatable = false)
    private CommitteeHeader committeHeader;

    @ManyToOne
    @JoinColumn(name = "com_desgn_id", referencedColumnName = "com_desgn_id", insertable = false, updatable = false)
    private CommitteeDesignation committeDesignation;
}
