package com.arasmo.carrentalsales.carrentalsale_service.enums;

public enum BookingStatusTypes {
    BOOKED,     //Payment done and car is reserved successfully.
    CANCELLED,  //Booking canceled by the user or admin.
    PENDING,    //Booking created but payment not confirmed yet.
    ONGOING,    //Customer has picked up the car, and the rental is in progress.
    COMPLETED,  //Customer returned the car, booking is finished.
    NOSHOW,     //Customer did not pick up the car after booking.
    EXPIRED     //Customer did not pick up the car after booking.
}
