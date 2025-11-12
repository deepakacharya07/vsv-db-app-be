package com.bengaluru.vsv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String individualPhotoUrl;

    @Lob
    @Column(name = "family_photo")
    private String familyPhotoUrl;

    // ✅ New fields for actual binary data
    @Lob
    @Column(name = "individual_photo_blob")
    private byte[] individualPhotoBlob;

    @Lob
    @Column(name = "family_photo_blob")
    private byte[] familyPhotoBlob;

    // Optional: Bidirectional mapping to VsvMemberMaster (if needed)
    @OneToOne
    @MapsId
    @JoinColumn(name = "vsv_id")
    private VsvMemberMaster memberMaster;

    // Override toString to avoid printing large blobs
    @Override
    public String toString() {
        return "VsvMemberPhoto{" +
                "vsvId=" + vsvId +
                ", individualPhoto=" + (individualPhotoUrl != null ? "[TEXT]" : "null") +
                ", familyPhoto=" + (familyPhotoUrl != null ? "[TEXT]" : "null") +
                ", individualPhotoBlob=" + (individualPhotoBlob != null ? "[BLOB]" : "null") +
                ", familyPhotoBlob=" + (familyPhotoBlob != null ? "[BLOB]" : "null") +
                '}';
    }
}
