package com.arasmo.carrentalsales.carrentalsale_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicle_booking_bills")
public class VehicleBookingBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_booking_bills_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_bookings_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vehicle_bookings_vehicle_booking_bill"))
    private VehicleBookings vehicleBookings;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "vehicle_booking_price_id", nullable = false, foreignKey = @ForeignKey(name = "FK_vehicle_booking_price_vehicle_booking_bill"))
    private VehicleBookingPrice vehicleBookingPrice;

    @Column(name = "base_price", nullable = false)
    private Double basePrice;

    @Column(name = "extra_km_price", nullable = false)
    private Integer extraKmPrice;

    @Column(name = "extra_hr_price", nullable = false)
    private Integer extraHrPrice;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
}
