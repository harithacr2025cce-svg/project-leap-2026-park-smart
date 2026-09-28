package com.example.park_smart.controller;

import com.example.park_smart.model.ParkingSlot;
import com.example.park_smart.service.ParkingSlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
@CrossOrigin
public class ParkingSlotController {

    private final ParkingSlotService parkingSlotService;

    public ParkingSlotController(ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
    }

    @GetMapping
    public List<ParkingSlot> getAllSlots() {
        return parkingSlotService.getAllSlots();
    }

    @PostMapping
    public ParkingSlot addSlot(@RequestBody ParkingSlot parkingSlot) {
        return parkingSlotService.addSlot(parkingSlot);
    }

    @PutMapping("/{id}")
    public ParkingSlot updateSlot(
            @PathVariable Long id,
            @RequestBody ParkingSlot parkingSlot) {
        return parkingSlotService.updateSlot(id, parkingSlot);
    }

    @DeleteMapping("/{id}")
    public void deleteSlot(@PathVariable Long id) {
        parkingSlotService.deleteSlot(id);
    }
}