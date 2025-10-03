package com.bengaluru.vsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Entity
@Table(name = "vsv_member_photo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VsvMemberPhoto {

    @Id
    @Column(name = "vsv_id", nullable = false)
    private Integer vsvId;

    @Lob
    @Column(name = "individual_photo")
    private String individualPhoto;

    @Lob
    @Column(name = "family_photo")
    private String familyPhoto;

    // Optional: Bidirectional mapping to VsvMemberMaster (if needed)
    @OneToOne
    @MapsId
    @JoinColumn(name = "vsv_id")
    private VsvMemberMaster memberMaster;

    // toString (avoid printing full photo blobs)
    @Override
    public String toString() {
        return "VsvMemberPhoto{" +
                "vsvId=" + vsvId +
                ", individualPhoto=" + (individualPhoto != null ? "[BLOB]" : "null") +
                ", familyPhoto=" + (familyPhoto != null ? "[BLOB]" : "null") +
                '}';
    }
}
