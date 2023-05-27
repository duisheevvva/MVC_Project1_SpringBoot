package peaksoft.service;

import peaksoft.entity.Agency;
import peaksoft.entity.Booking;

import java.util.List;

public interface BookingService {
    void saveBooking(Booking booking);

    List<Booking> getAll(Long id);

    List<Booking> getAllBooking();

    Booking getBookingById(Long id);

    void updateBooking( Booking booking);

    void deleteBookingById(Long id);

}
