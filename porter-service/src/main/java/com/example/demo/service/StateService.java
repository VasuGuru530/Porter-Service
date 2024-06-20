package com.example.demo.service;

import com.example.demo.entity.StateEntity;
import com.example.demo.model.State;
import com.example.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


public interface StateService {

List<State> findStateByCountryId(Long CountryId);

}
