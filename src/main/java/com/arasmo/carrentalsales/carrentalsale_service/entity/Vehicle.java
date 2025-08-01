package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "registered_number", nullable = false)
    private String registeredNumber;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "insurance_company", nullable = false)
    private String insuranceCompany;

    @Column(name = "insurance_number", nullable = false)
    private String insuranceNumber;

    @Column(name = "chasis_number", nullable = false)
    private String chasisNumber;

    @Column(name = "rc_pic", nullable = false)
    private String rcPic;

    @Column(name = "insurance_pic",nullable = false)
    private String insurancePic;

    @Column(name = "km_run", nullable = false)
    private String kmRun;

    @Column(length = 20, nullable = false)
    private String colour;

    @Column(nullable = false)
    private Integer mileage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vehicle_type_vehicle"))
    private VehicleType vehicleType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fuel_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_fuel_type_vehicle"))
    private FuelType fuelType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand", nullable = false, foreignKey = @ForeignKey(name = "FK_brand_vehicle"))
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "model_id", nullable = false, foreignKey = @ForeignKey(name = "FK_model_type_vehicle"))
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "variant_id", nullable = false, foreignKey = @ForeignKey(name = "FK_variant_vehicle"))
    private Variant variant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seater_id", nullable = false, foreignKey = @ForeignKey(name = "FK_seater_vehicle"))
    private Seater seater;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transmission_id", nullable = false, foreignKey = @ForeignKey(name = "FK_transmission_vehicle"))
    private Transmission transmission;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "_id", nullable = false, foreignKey = @ForeignKey(name = "FK_engineCapacity_vehicle"))
    private EngineCapacity engineCapacity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gear_id", nullable = false, foreignKey = @ForeignKey(name = "FK_gear_vehicle"))
    private Gear gear;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicleStatus_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vehicleStatus_vehicle"))
    private VehicleStatus vehicleStatus;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleInspection> vehicleInspections;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleAvailability> vehicleAvailabilities;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleAvailabilityHistory> vehicleAvailabilityHistories;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleFeatures> vehicleFeatures;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleImages> vehicleImages;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookings> vehicleBookings;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookingPrice> vehicleBookingPrices;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookingLogs> vehicleBookingLogs;
}
