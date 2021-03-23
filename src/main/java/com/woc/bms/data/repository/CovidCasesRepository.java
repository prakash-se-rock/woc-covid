package com.woc.bms.data.repository;

import com.woc.bms.data.model.CovidCases;
import com.woc.bms.data.model.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CovidCasesRepository extends JpaRepository<CovidCases, Integer> {

    List<CovidCases> findByState(State state);
    @Query("from CovidCases c where c.state.stateCode=:stateCodeParam")
    CovidCases getCovidCasesStateCode(@Param("stateCodeParam") String stateCode);
    
    @Query("from CovidCases c")
    List<CovidCases> getCovidCasesForAllStates();
}
