package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.services.Location.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private LocationService locationService;
    public LocationController(LocationService locationService)
    {
        this.locationService=locationService;
    }
    @GetMapping("/list")
    public String listLocations(Model theModel)
    {
        theModel.addAttribute("locations",locationService.findAllLocations());
        return "list-location";
    }
}
