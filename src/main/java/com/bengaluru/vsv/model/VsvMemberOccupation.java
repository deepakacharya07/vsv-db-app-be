package com.bengaluru.vsv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vsv_member_occupation")
@Getter
@Setter
@NoArgsConstructor
public class VsvMemberOccupation {
    @Id
    @Column(name = "vsv_id", nullable = false)
    private Integer vsvId;

    @Column(name = "Employement_Status_ID")
    private Integer employementStatusId;

    @Column(name = "Salary_Slab_ID")
    private Integer salarySlabId;

    @Column(name = "Occupation_Details", length = 70)
    private String occupationDetails;

    @Column(name = "Office_Address", length = 150)
    private String officeAddress;

    @Column(name = "Bank", length = 45)
    private String bank;

    // If there's a corresponding VsvMemberMaster entity, you can use @OneToOne or @ManyToOne
    // Assuming One-to-One here
    @OneToOne
    @MapsId
    @JoinColumn(name = "vsv_id")
    @JsonBackReference
    private VsvMemberMaster memberMaster;
}
