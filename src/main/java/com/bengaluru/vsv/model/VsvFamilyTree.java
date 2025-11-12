package com.bengaluru.vsv.model;

import com.bengaluru.vsv.model.keys.VsvFamilyTreeKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    // Reference to the relationship type
    @ManyToOne
    @JoinColumn(name = "relation_id", insertable = false, updatable = false)
    private Relationship relationship;

    // Optional: Reference to related member (e.g., father, mother)
    // Add only if you want this mapped
    @ManyToOne
    @JoinColumn(name = "relation_vsv_id", insertable = false, updatable = false)
    private VsvMemberMaster relatedMember;
}
