package com.bengaluru.vsv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "vsv_id")
    private Integer vsvId;

    @Column(name = "present_address", length = 150)
    private String presentAddress;

    @Column(name = "present_pin")
    private Integer presentPin;

    @Column(name = "present_google_map_locn", length = 350)
    private String presentGoogleMapLocn;

    @Column(name = "permanent_address", length = 150)
    private String permanentAddress;

    @Column(name = "permanent_pin")
    private Integer permanentPin;

    @Column(name = "permanent_google_map_locn", length = 350)
    private String permanentGoogleMapLocn;

    @Column(name = "whatsapp_no", length = 15)
    private String whatsappNo;

    @Column(name = "landline_no", length = 15)
    private String landLineNo;

    @Column(name = "email_id", length = 45)
    private String emailId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "vsv_id")
    private VsvMemberMaster member;
}
