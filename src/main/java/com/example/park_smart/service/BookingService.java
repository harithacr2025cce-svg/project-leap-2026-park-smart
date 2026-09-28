package com.example.park_smart.service;

import com.example.park_smart.model.Booking;
import com.example.park_smart.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {

        // Automatically calculate penalty
        calculatePenalty(booking);

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {

        Optional<Booking> booking = bookingRepository.findById(id);

        if (booking.isPresent()) {
            return booking.get();
        }

        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private void calculatePenalty(Booking booking) {

        if (booking.getEndTime() == null ||
                booking.getActualExitTime() == null) {

            booking.setPenaltyAmount(0);
            return;
        }

        LocalDateTime endTime = booking.getEndTime();
        LocalDateTime actualExitTime = booking.getActualExitTime();

        if (actualExitTime.isAfter(endTime)) {

            long minutesLate =
                    Duration.between(endTime, actualExitTime).toMinutes();

            // ₹100 per hour
            double penalty = (minutesLate / 60.0) * 100;

            booking.setPenaltyAmount(penalty);
            booking.setStatus("Overstay");

        } else {

            booking.setPenaltyAmount(0);
            booking.setStatus("Booked");
        }
    }
}