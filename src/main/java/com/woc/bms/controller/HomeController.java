package com.woc.bms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.woc.bms.data.model.Customer;
import com.woc.bms.service.CustomerAuthDetails;
import com.woc.bms.service.DataService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class HomeController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String redirectToIndexPage(){
        return "index";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    private Customer getLoggedInCustomer() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomerAuthDetails) {
            CustomerAuthDetails customerAuthDetails = (CustomerAuthDetails) principal;
            return customerAuthDetails.getCustomer();
        }

        throw new IllegalStateException("Unable to get the Customer info from security principal");
    }

    @PostMapping("/home")
    public String forwardHome(ModelMap model, HttpServletRequest request){
        return home(model, request);
    }

    @GetMapping("/home")
    public String home(ModelMap model, HttpServletRequest request){
        log.info("home api has been triggered.");
        model.put("covidallcases", dataService.getCovidCasesForAllStates());

        HttpSession session = request.getSession(false);
        if(null != session){
            Customer loggedInCustomer = getLoggedInCustomer();
            session.setAttribute("customerName", loggedInCustomer.getName());
            session.setAttribute("customerId", loggedInCustomer.getId());
        }
        return "home";
    }

    @GetMapping("/covidcases/state/{stateCode}")
    public String getCovidCasesByStateCode(@PathVariable("stateCode") String stateCode, ModelMap model){
        model.put("covidcases", dataService.getCovidCasesStateCode(stateCode));
        return "covidcases";
    }
    

    @GetMapping("/covidcases/states")
    public String getCovidCasesForAllStates(ModelMap model){
        model.put("covidallcases", dataService.getCovidCasesForAllStates());
        return "covidallcases";
    }
}
