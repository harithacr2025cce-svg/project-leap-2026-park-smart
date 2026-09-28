package com.example.park_smart.repository;

import com.example.park_smart.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsBySlotNumberAndStartTimeLessThanAndEndTimeGreaterThan(
            String slotNumber,
            LocalDateTime endTime,
            LocalDateTime startTime
    );

}