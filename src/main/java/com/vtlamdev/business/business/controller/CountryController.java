package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.entity.Country;
import com.vtlamdev.business.business.services.Country.CountryService;
import com.vtlamdev.business.business.services.Region.RegionService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( "/countries")
public class CountryController {
    private CountryService countryService;
    private RegionService regionService;
    public CountryController(CountryService countryService, RegionService regionService)
    {
        this.countryService=countryService;
        this.regionService=regionService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping( "/list")
    public String showListCountries(Model theModel)
    {
        //theModel.addAttribute("countries",countryService.findAllCountry());
        theModel.addAttribute("countries",countryService.findAllCountriesAndLocationByJoinFetch());
        return "list-countries";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("countryId") String countryId, Model theModel)
    {
        theModel.addAttribute("country",countryService.findCountryById(countryId));
        theModel.addAttribute("regions",regionService.findAllRegion());
        return "add-country";
    }
    @PostMapping("/save")
    public String saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult)
    {
        System.out.println(country);
        if(bindingResult.hasErrors())
        {
            return "add-country";
        }
        else
        {
            countryService.saveCountry(country);
            return"redirect:/countries/list";
        }

    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        theModel.addAttribute("country",new Country());
        theModel.addAttribute("regions",regionService.findAllRegion());
        return "add-country";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("countryId") String countryId)
    {
        countryService.deleteCountryById(countryId);
        return"redirect:/countries/list";
    }
}
