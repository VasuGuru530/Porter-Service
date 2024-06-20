package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.model.State;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.StateRepository;

@Service
public class DataFetchService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<State> getStatesByCountry(Long countryId) {
        return stateRepository.findByCountryId(countryId);
    }
}
