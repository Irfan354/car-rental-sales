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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vehicle_booking_prices")
public class VehicleBookingPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_booking_prices_id")
    private Long id;

    @Column(name = "base_price", nullable = false)
    private Double basePrice;

    @Column(name = "km_included", nullable = false)
    private Integer kmIncluded;

    @Column(name = "hr_included", nullable = false)
    private Integer hrIncluded;

    @Column(name = "extra_hr_rate", nullable = false)
    private Double extraKmRate;

    @Column(name = "extra_hr_rate", nullable = false)
    private Double extraHrRate;

    @Column(name = "is_unlimited_allowed", nullable = false)
    private Boolean isUnlimitedAllowed;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false, foreignKey = @ForeignKey(name="FK_vehicle_booking_price_vehicle"))
    private Vehicle Vehicle;

    @OneToMany( mappedBy = "vehicle_booking_price",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookingBill> vehicleBookingBills;
}

