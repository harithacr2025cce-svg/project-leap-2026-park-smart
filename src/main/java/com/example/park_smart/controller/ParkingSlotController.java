package com.example.park_smart.controller;


import com.example.park_smart.model.ParkingSlot;
import com.example.park_smart.service.ParkingSlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class ParkingSlotController {

    private ParkingSlotService service;

    public ParkingSlotController(ParkingSlotService service) {
        this.service = service;
    }

    @PostMapping
    public ParkingSlot add(@RequestBody ParkingSlot slot) {
        return service.createSlot(slot);
    }

    @GetMapping
    public List<ParkingSlot> getAll() {
        return service.getAllSlots();
    }

    @PutMapping("/{id}")
    public ParkingSlot update(@PathVariable Long id,
                              @RequestBody ParkingSlot slot) {
        return service.updateSlot(id, slot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSlot(id);
    }


}
