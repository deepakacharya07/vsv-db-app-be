package com.bengaluru.vsv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vsv_member_horoscope")
@Getter
@Setter
@NoArgsConstructor
public class VsvMemberHoroscope {

    @Id
    @Column(name = "vsv_id", nullable = false)
    private Integer vsvId;

    @Column(name = "nakshatra")
    private Integer nakshatra;

    @Column(name = "rashi")
    private Integer rashi;

    @Column(name = "gothra")
    private Integer gothra;

    @Column(name = "matha")
    private Integer matha;

    @OneToOne
    @MapsId
    @JoinColumn(name = "vsv_id")
    @JsonBackReference
    private VsvMemberMaster memberMaster;

    @Override
    public String toString() {
        return "VsvMemberHoroscope{" +
                "vsvId=" + vsvId +
                ", nakshatra=" + (nakshatra != null ? matha : "null") +
                ", rashi=" + (rashi != null ? rashi : "null") +
                ", gothra=" + (gothra != null ? gothra : "null") +
                ", matha=" + (matha != null ? matha : "null") +
                '}';
    }}
