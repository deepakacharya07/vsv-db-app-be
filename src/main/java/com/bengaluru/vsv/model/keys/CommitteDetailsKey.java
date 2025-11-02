package com.bengaluru.vsv.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class CommitteDetailsKey implements Serializable {

    @Column(name = "committe_loc_id", nullable = false)
    private int committeLocId;

    @Column(name = "committe_id", nullable = false)
    private int committeId;

    @Column(name = "com_desgn_id", nullable = false)
    private int comDesgnId;

    @Column(name = "vsv_id", nullable = false)
    private Integer vsvId;

    // hashCode and equals are required for composite keys

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommitteDetailsKey)) return false;
        CommitteDetailsKey that = (CommitteDetailsKey) o;
        return committeLocId == that.committeLocId &&
                committeId == that.committeId &&
                comDesgnId == that.comDesgnId &&
                vsvId == that.vsvId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(committeLocId, committeId, comDesgnId, vsvId);
    }
}
