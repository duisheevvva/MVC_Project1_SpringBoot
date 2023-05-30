package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import peaksoft.entity.Booking;



public interface BookingRepository  extends JpaRepository<Booking,Long> {



}
