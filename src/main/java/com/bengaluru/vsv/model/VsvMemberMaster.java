package com.bengaluru.vsv.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "vsv_member_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VsvMemberMaster {

    @Id
    @Column(name = "VSV_ID", nullable = false)
    private Integer vsvId;

    @Column(name = "Name", nullable = false, length = 60)
    private String name;

    @Column(name = "Gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "DOB", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "Age", nullable = false)
    private Integer age;

    @Column(name = "Birth_Place", length = 45)
    private String birthPlace;

    @Column(name = "NativePlace", length = 45)
    private String nativePlace;

    @Column(name = "Marital_Status", nullable = false)
    private Integer maritalStatus;

    @Column(name = "Mobile_No", nullable = false, length = 15)
    private String mobileNo;

    @Column(name = "Blood_Group")
    private Integer bloodGroup;

    @Column(name = "Qualification_ID")
    private Integer qualificationId;

    @Column(name = "Is_Student", nullable = false)
    private Boolean isStudent;

    @Column(name = "Course_Detail", length = 100)
    private String courseDetail;

    @Column(name = "Member_Status")
    private Integer memberStatus;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "Committe_ID", nullable = false)
    //private CommitteMaster committe;

    @Column(name = "CreatedUser", length = 10)
    private String createdUser;

    @Column(name = "CreatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @Column(name = "UpdatedUser", length = 10)
    private String updatedUser;

    @Column(name = "UpdatedDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDateTime;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VsvMemberContact contact;
}

