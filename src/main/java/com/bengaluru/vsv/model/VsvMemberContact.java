package com.bengaluru.vsv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vsv_member_contact")
@Data
public class VsvMemberContact {
    @Id
    @Column(name = "VSV_ID")
    private Integer vsvId;

    @Column(name = "Present_Address", length = 150)
    private String presentAddress;

    @Column(name = "Present_PIN")
    private Integer presentPin;

    @Column(name = "Present_Google_Map_Locn", length = 350)
    private String presentGoogleMapLocn;

    @Column(name = "Permanent_Address", length = 150)
    private String permanentAddress;

    @Column(name = "Permanent_PIN")
    private Integer permanentPin;

    @Column(name = "Permanent_Google_Map_Locn", length = 350)
    private String permanentGoogleMapLocn;

    @Column(name = "Whatsapp_No", length = 15)
    private String whatsappNo;

    @Column(name = "LandLine_No", length = 15)
    private String landLineNo;

    @Column(name = "EmailID", length = 45)
    private String emailId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "VSV_ID")
    private VsvMemberMaster member;
}
