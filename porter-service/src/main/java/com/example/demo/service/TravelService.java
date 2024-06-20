package com.example.demo.service;

import com.example.demo.entity.TravelEntity;
import java.util.List;

public interface TravelService {
    TravelEntity saveTravel(TravelEntity travel);
    TravelEntity getTravelById(Long id);
    List<TravelEntity> getAllTravels();
    TravelEntity updateTravel(Long id, TravelEntity travel);
    void deleteTravel(Long id);
}
