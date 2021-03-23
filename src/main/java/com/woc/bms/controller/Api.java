package com.woc.bms.controller;

import com.woc.bms.data.model.State;
import com.woc.bms.data.model.CovidCases;
import com.woc.bms.service.DataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Api {

    @Autowired
    private DataService dataService;

    @GetMapping("/city")
    public List<State> getAllCity(){
        return dataService.getAllCity();
    }

    @Cacheable("stateCode")
    @GetMapping("/state/code/{stateCode}")
    public CovidCases getCovidCasesStateCode(@PathVariable("stateCode") String stateCode){
        System.out.println("getTheatreByCityCode api for cityCode="+stateCode + " has been triggered");
        CovidCases cases = dataService.getCovidCasesStateCode(stateCode);
        return cases;
    }

}
