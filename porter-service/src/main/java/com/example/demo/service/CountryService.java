package com.example.demo.service;

import com.example.demo.entity.CountryEntity;
import com.example.demo.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryById(Long id);
}
