package com.bengaluru.vsv.model;

import com.bengaluru.vsv.model.keys.VsvFamilyTreeKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vsv_family_tree")
@Getter
@Setter
public class VsvFamilyTree {

    @EmbeddedId
    private VsvFamilyTreeKey id;

    @Column(name = "relation_name", length = 60)
    private String relationName;

    @Column(name = "relation_vsv_id")
    private Integer relationVsvId;

    // --- Relationships ---

    // Reference to the main member
//    @ManyToOne
//    @JoinColumn(name = "vsv_id", insertable = false, updatable = false)
//    private VsvMemberMaster member;

    // Reference to the relationship type
    @ManyToOne
    @JoinColumn(name = "relation_id", insertable = false, updatable = false)
    private Relationship relationship;

    // Optional: Reference to related member (e.g., father, mother)
    // Add only if you want this mapped
//    @ManyToOne
//    @JoinColumn(name = "relation_vsv_id", insertable = false, updatable = false)
//    private VsvMemberMaster relatedMember;
}
