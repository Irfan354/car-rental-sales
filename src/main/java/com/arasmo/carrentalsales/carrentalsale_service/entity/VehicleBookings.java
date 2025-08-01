package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.time.LocalDateTime;
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
@Table(name = "vehicle_bookings")
public class VehicleBookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "vehicle_booking_id")
    private Long id;

    @Column(name = "booking_number", unique = true, length = 50, nullable = false)
    private String bookingNumber;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @OneToMany(mappedBy = "vehicle_bookings", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookingLogs> vehicleBookingLogs;

    @OneToMany(mappedBy = "vehicle_bookings", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookingBill> vehicleBookingBills;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false, foreignKey = @ForeignKey(name="FK_vehicle_vehicle_bookings"))
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_customer_vehicle_bookings"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cutomer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_customer_vehicle_bookings"))
    private BookingStatus bookingStatus;
}
