package com.example.demo.service.impl;

import com.example.demo.entity.TravelEntity;
import com.example.demo.repository.TravelRepository;
import com.example.demo.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public TravelEntity saveTravel(TravelEntity travel) {
        return travelRepository.save(travel);
    }

    @Override
    public TravelEntity getTravelById(Long id) {
        Optional<TravelEntity> optionalTravel = travelRepository.findById(id);
        return optionalTravel.orElseThrow(() -> new RuntimeException("Travel not found"));
    }

    @Override
    public List<TravelEntity> getAllTravels() {
        return travelRepository.findAll();
    }

    @Override
    public TravelEntity updateTravel(Long id, TravelEntity travel) {
        TravelEntity existingTravel = getTravelById(id);
        existingTravel.setFrom(travel.getFrom());
        existingTravel.setTo(travel.getTo());
        existingTravel.setCity(travel.getCity());
        existingTravel.setDateTime(travel.getDateTime());
        existingTravel.setWeight(travel.getWeight());
        existingTravel.setExpectedCost(travel.getExpectedCost());
        existingTravel.setVoluntary(travel.getVoluntary());
        existingTravel.setCreatedDate(travel.getCreatedDate());
        existingTravel.setCreatedBy(travel.getCreatedBy());
        existingTravel.setUpdatedDate(travel.getUpdatedDate());
        existingTravel.setUpdatedBy(travel.getUpdatedBy());
        existingTravel.setStatus(travel.getStatus());
        return travelRepository.save(existingTravel);
    }

    @Override
    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }
}
