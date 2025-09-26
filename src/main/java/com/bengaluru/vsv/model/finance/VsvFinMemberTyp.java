package com.bengaluru.vsv.model.finance;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vsv_fin_member_typ")
@Data
public class VsvFinMemberTyp {
    @Id
    @Column(name = "invoice_member_id")
    private Integer invMemberId;

    @Column(name = "member_description", length = 45)
    private String memberDescription;
}
