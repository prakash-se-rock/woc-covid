package com.woc.bms.dao.impl;

import com.woc.bms.dao.DataDao;
import com.woc.bms.data.model.State;
import com.woc.bms.data.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDaoImpl implements DataDao {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<State> getAllCity() {
        return cityRepository.findAll();
    }
}
