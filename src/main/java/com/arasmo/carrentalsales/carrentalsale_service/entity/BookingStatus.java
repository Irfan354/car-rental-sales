package com.arasmo.carrentalsales.carrentalsale_service.entity;

import java.util.Set;

import com.arasmo.carrentalsales.carrentalsale_service.enums.BookingStatusTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "booking_status")
public class BookingStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_status_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookingStatusTypes BookingStatusTypes;

    @OneToMany(mappedBy = "booking_status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookingLogs> vehicleBookingLogs;

    @OneToMany(mappedBy = "booking_status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<VehicleBookings> vehicleBookings;
}
