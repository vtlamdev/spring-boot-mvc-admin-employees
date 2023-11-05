package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.services.Dependent.DependentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dependents")
public class DependentController {
    private DependentService dependentService;
    public DependentController(DependentService dependentService)
    {
        this.dependentService=dependentService;
    }
    @GetMapping("/list")
    public String listDependents(Model theModel)
    {
        theModel.addAttribute("dependents", dependentService.findAllDependents());
        return "list-dependent";
    }
    // add, update, delete, how to add dependent and employee at the same time in a page
}
