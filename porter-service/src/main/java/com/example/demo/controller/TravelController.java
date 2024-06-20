package com.example.demo.controller;

import com.example.demo.entity.TravelEntity;
import com.example.demo.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @PostMapping("/travel")
    public TravelEntity createTravel(@RequestBody TravelEntity travel) {
        return travelService.saveTravel(travel);
    }

    @GetMapping("/{id}")
    public TravelEntity getTravelById(@PathVariable Long id) {
        return travelService.getTravelById(id);
    }

    @GetMapping("/travelList")
    public List<TravelEntity> getAllTravels() {
        return travelService.getAllTravels();
    }

    @PutMapping("/{id}")
    public TravelEntity updateTravel(@PathVariable Long id, @RequestBody TravelEntity travel) {
        return travelService.updateTravel(id, travel);
    }

    @DeleteMapping("/{id}")
    public void deleteTravel(@PathVariable Long id) {
        travelService.deleteTravel(id);
    }
}
