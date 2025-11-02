package com.bengaluru.vsv.model.committee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "committe_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VsvCommitteeMaster {

    @Id
    @Column(name = "committe_id", nullable = false)
    private Integer committeId;

    @Column(name = "committe_name", length = 60)
    private String committeName;

    @Column(name = "registration_no", length = 60)
    private String registrationNo;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "state", length = 45)
    private String state;

    @Column(name = "pin")
    private Long pin;

    @Column(name = "contact_number", length = 45)
    private String contactNumber;

    @Column(name = "bank_account_number", length = 45)
    private String bankAccountNumber;

    @Column(name = "bank_branch", length = 45)
    private String bankBranch;

    @Column(name = "bank_name", length = 45)
    private String bankName;

    @Column(name = "bank_ifsc", length = 45)
    private String bankIFSC;

    @Column(name = "upi_address", length = 45)
    private String upiAddress;

    //@OneToMany(mappedBy = "committe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<VsvMemberMaster> members;
}
