package com.woc.bms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woc.bms.dao.DataDao;
import com.woc.bms.data.model.CovidCases;
import com.woc.bms.data.model.State;
import com.woc.bms.data.repository.CovidCasesRepository;

@Service
public class DataService {

    @Autowired private DataDao dataDao;
    @Autowired private CovidCasesRepository covidCaseRepository;


    public List<State> getAllCity() {
        return dataDao.getAllCity();
    }

    public CovidCases getCovidCasesStateCode(String stateCode){
        CovidCases covidCases = covidCaseRepository.getCovidCasesStateCode(stateCode);
        return covidCases;
    }
    
    
    public List<CovidCases> getCovidCasesForAllStates(){
        List<CovidCases> covidCases = covidCaseRepository.getCovidCasesForAllStates();
        List<CovidCases> collect = covidCases.stream().map(c -> {
        	CovidCases cc = new CovidCases();
        	cc.setState(c.getState());
            cc.setActiveCases(c.getActiveCases());
            cc.setTotalCase(c.getTotalCase());
            cc.setRecoverCases(c.getRecoverCases());
            cc.setDeathCases(c.getDeathCases());
            return cc;
        }).collect(Collectors.toList());
        return collect;
    }
}
