package com.bengaluru.vsv.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "committe_master")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitteMaster {

    @Id
    @Column(name = "Committe_ID", nullable = false)
    private Integer committeId;

    @Column(name = "Committe_Name", length = 60)
    private String committeName;

    @Column(name = "Registration_No", length = 60)
    private String registrationNo;

    @Column(name = "Address", length = 60)
    private String address;

    @Column(name = "City", length = 45)
    private String city;

    @Column(name = "State", length = 45)
    private String state;

    @Column(name = "PIN")
    private Long pin;

    @Column(name = "ContactNumber", length = 45)
    private String contactNumber;

    @Column(name = "BankAccountNumber", length = 45)
    private String bankAccountNumber;

    @Column(name = "BankBranch", length = 45)
    private String bankBranch;

    @Column(name = "BankName", length = 45)
    private String bankName;

    @Column(name = "BankIFSC", length = 45)
    private String bankIFSC;

    @Column(name = "UPIAddress", length = 45)
    private String upiAddress;

    //@OneToMany(mappedBy = "committe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<VsvMemberMaster> members;
}
