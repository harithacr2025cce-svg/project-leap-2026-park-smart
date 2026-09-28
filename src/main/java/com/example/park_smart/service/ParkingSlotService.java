package com.example.park_smart.service;

import com.example.park_smart.model.ParkingSlot;
import com.example.park_smart.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotService {

    private final ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }

    public ParkingSlot addSlot(ParkingSlot parkingSlot) {
        return parkingSlotRepository.save(parkingSlot);
    }

    public ParkingSlot updateSlot(Long id, ParkingSlot parkingSlot) {
        parkingSlot.setId(id);
        return parkingSlotRepository.save(parkingSlot);
    }

    public void deleteSlot(Long id) {
        parkingSlotRepository.deleteById(id);
    }
}