package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Booking;
import peaksoft.entity.Customer;
import peaksoft.entity.House;
import peaksoft.exception.MyException;
import peaksoft.repository.BookingRepository;
import peaksoft.repository.CustomerRepository;
import peaksoft.repository.HouseRepository;
import peaksoft.service.BookingService;
import peaksoft.service.CustomerService;
import peaksoft.service.HouseService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final HouseRepository houseRepository;

    @Override
    public void saveBooking(Booking booking, Long customerId, Long houseId) {
        try{
            customerRepository.findById(customerId).orElseThrow(()->new MyException("not found!"));
            houseRepository.findById(houseId).orElseThrow(()->new MyException("not found!"));

        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public List<Booking> getAll(Long id) {
        return null;
    }

    @Override
    public List<Booking> getAllBooking() {
        return null;
    }

    @Override
    public Booking getBookingById(Long id) {
        return null;
    }

    @Override
    public void updateBooking(Booking booking) {

    }

    @Override
    public void deleteBookingById(Long id) {

    }
}
