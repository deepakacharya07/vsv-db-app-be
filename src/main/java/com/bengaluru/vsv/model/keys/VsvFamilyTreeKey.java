package com.bengaluru.vsv.model.keys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VsvFamilyTreeKey implements Serializable {

    @Column(name = "vsv_id", nullable = false)
    private Integer vsvId;

    @Column(name = "relation_id", nullable = false)
    private Integer relationId;

    @Column(name = "order", nullable = false)
    private Integer order;


    // equals() and hashCode() required for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VsvFamilyTreeKey)) return false;
        VsvFamilyTreeKey that = (VsvFamilyTreeKey) o;
        return Objects.equals(vsvId, that.vsvId) &&
               Objects.equals(relationId, that.relationId) &&
               Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vsvId, relationId, order);
    }
}
