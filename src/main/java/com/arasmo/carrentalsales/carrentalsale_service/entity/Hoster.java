package com.arasmo.carrentalsales.carrentalsale_service.entity;


import com.arasmo.carrentalsales.carrentalsale_service.enums.ApprovalStatus;
import com.arasmo.carrentalsales.carrentalsale_service.enums.HosterStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hosters")
public class Hoster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hoster_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(unique = true,length = 20, nullable = false)
    private String mobile;

    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @Column(unique = true,length = 20, nullable = false)
    private String alternateMobile;

    @Column(length = 500, columnDefinition = "TEXT")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "state_id", nullable = false, foreignKey = @ForeignKey(name = "FK_hoster_state"))
    private State state;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "city_id", nullable = false, foreignKey = @ForeignKey(name = "FK_hoster_city"))
    private City city;

    @Column(length = 6, nullable = false)
    private String pincode;

    @Column(name = "aadhar_number", unique = true, nullable = false, length = 12)
    private String aadharNumber;

    @Column(name = "aadhar_front_pic", nullable = false)
    private String aadharFrontPic;

    @Column(name = "aadhar_back_pic", nullable = false)
    private String aadharBackPic;

    @Column(name = "pan_number", unique = true, nullable = false, length = 10)
    private String panNumber;

    @Column(name = "pan_pic", nullable = false)
    private String panPic;

    @Column(name = "profile_pic", nullable = false)
    private String profilePic;

    @Enumerated(EnumType.STRING)
    @Column(name = "hoster_status", nullable = false)
    private HosterStatus hosterStatus;  //Active, InActive

    @Enumerated(EnumType.STRING)
    @Column(name = "approval_status", nullable = false)
    private ApprovalStatus approvalStatus;  //Rejected, Approved, In-Progress

    @Column(length = 500, columnDefinition = "TEXT")
    private String reason;


}
