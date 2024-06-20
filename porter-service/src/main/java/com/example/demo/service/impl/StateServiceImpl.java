package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Country;
import com.example.demo.model.State;
import com.example.demo.repository.StateRepository;
import com.example.demo.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
    private StateRepository stateRepository;

    

	 @Override
	    public List<State> findStateByCountryId(Long countryId) {
	        return stateRepository.findByCountryId(countryId);
	    }



		

}
