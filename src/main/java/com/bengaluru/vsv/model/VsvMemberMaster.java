package com.bengaluru.vsv.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
    @Column(name = "vsv_id", nullable = false)
    private Integer vsvId;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "dob", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "birth_place", length = 45)
    private String birthPlace;

    @Column(name = "native_place", length = 45)
    private String nativePlace;

    @Column(name = "marital_status", nullable = false)
    private Integer maritalStatus;

    @Column(name = "mobile_no", nullable = false, length = 15)
    private String mobileNo;

    @Column(name = "blood_group")
    private Integer bloodGroup;

    @Column(name = "qualification_id")
    private Integer qualificationId;

    @Column(name = "is_student", nullable = false)
    private Boolean isStudent;

    @Column(name = "course_detail", length = 100)
    private String courseDetail;

    @Column(name = "member_status")
    private Integer memberStatus;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "Committe_ID", nullable = false)
    //private CommitteMaster committe;

    @Column(name = "created_user", length = 10)
    private String createdUser;

    @Column(name = "created_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    @Column(name = "updated_user", length = 10)
    private String updatedUser;

    @Column(name = "updated_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDateTime;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VsvMemberContact contact;

    @OneToOne(mappedBy = "memberMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private VsvMemberPhoto memberPhoto;

    //@OneToOne(mappedBy = "memberMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToOne(mappedBy = "memberMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private VsvMemberHoroscope memberHoroscope;

    @OneToOne(mappedBy = "memberMaster", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private VsvMemberOccupation memberOccupation;

}

