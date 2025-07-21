package com.bookingservice.repository;

import com.bookingservice.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingservice.entity.BookingDate;

public interface BookingRepository extends JpaRepository<Bookings, Long> {

}
