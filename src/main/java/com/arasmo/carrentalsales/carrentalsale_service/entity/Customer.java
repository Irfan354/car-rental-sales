package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.util.Set;

import com.arasmo.carrentalsales.carrentalsale_service.enums.CustomerStatus;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;
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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20, unique = true, nullable = false)
    private String mobile;

    @Column(length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "alternate_mobile",length = 50, unique = true)
    private String alternateMobile;

    @Column(length = 200, columnDefinition = "TEXT")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "state", foreignKey = @ForeignKey(name = "FK_customer_state"))
    private State state;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city", foreignKey = @ForeignKey(name = "FK_customer_city"))
    private City city;

    @Column(nullable = false)
    private String pincode;

    @Column(name = "aadhar_number",length = 20, unique = true, nullable = false)
    private String aadharNumber;

    @Column(name = "aadhar_front_pic", nullable = false)
    private String aadharFrontPic;

    @Column(name = "aadhar_back_pic", nullable = false)
    private String aadharBackPic;

    @Column(name = "profile_pic",nullable = false)
    private String profilePic;

    @Column(name = "driving_license_number",nullable = false)
    private String drivingLicenseNumber;

    @Column(name = "driving_license_front_pic", nullable = false)
    private String drivingLicenseFrontPic;

    @Column(name = "driving_license_back_pic", nullable = false)
    private String drivingLicenseBackPic;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status", nullable = false) 
    private CustomerStatus customerStatus; //Active, inactive

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookings> vehicleBookings;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set<VehicleBookingLogs> vehicleBookingLogs;

}
