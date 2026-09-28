package com.example.park_smart.service;

import com.example.park_smart.model.ParkingSlot;
import com.example.park_smart.repository.ParkingSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotService {

    private  ParkingSlotRepository repository;

    public ParkingSlotService(ParkingSlotRepository repository) {
        this.repository = repository;
    }

    public ParkingSlot createSlot(ParkingSlot slot) {
        return repository.save(slot);
    }

    public List<ParkingSlot> getAllSlots() {
        return repository.findAll();
    }

    public ParkingSlot updateSlot(Long id, ParkingSlot slot) {
        slot.setId(id);
        return repository.save(slot);
    }

    public void deleteSlot(Long id) {
        repository.deleteById(id);
    }

}
