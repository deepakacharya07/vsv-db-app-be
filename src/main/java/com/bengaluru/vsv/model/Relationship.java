package com.bengaluru.vsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "relationship")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Relationship implements Serializable {

    @Id
    @Column(name = "relation_id", nullable = false)
    private Integer relationId;

    @Column(name = "relation_description", length = 45)
    private String relationDescription;

    @Column(name = "level", columnDefinition = "int(1) unsigned zerofill")
    private Integer level;

    // Optional: toString()
    @Override
    public String toString() {
        return "Relationship{" +
                "relationId=" + relationId +
                ", relationDescription='" + relationDescription + '\'' +
                ", level=" + level +
                '}';
    }
}
