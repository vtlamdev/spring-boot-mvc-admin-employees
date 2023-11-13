package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.entity.Dependent;
import com.vtlamdev.business.business.services.Dependent.DependentService;
import com.vtlamdev.business.business.services.Employee.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dependents")
public class DependentController {
    private DependentService dependentService;
    private EmployeeService employeeService;
    public DependentController(DependentService dependentService, EmployeeService employeeService)
    {
        this.dependentService=dependentService;
        this.employeeService=employeeService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/list")
    public String listDependents(Model theModel)
    {
        theModel.addAttribute("dependents", dependentService.findAllDependents());
        return "list-dependent";
    }
    @GetMapping("/showFormForAdd")
    public String addDependent(Model theModel)
    {
        theModel.addAttribute("dependent",new Dependent());
        theModel.addAttribute("employees", employeeService.findAllEmplooyees());
        return "add-dependent";
    }
    @GetMapping("/showFormForUpdate{dependentId}")
    public String updateDependent(@RequestParam("dependentId") int dependentId, Model theModel)
    {
        theModel.addAttribute("dependent",dependentService.findDependentById(dependentId));
        theModel.addAttribute("employees", employeeService.findAllEmplooyees());
        return "add-dependent";
    }
    @GetMapping("delete{dependentId}")
    public String deleteDependent(@RequestParam("dependentId") int dependentId)
    {
        dependentService.deleteDependentById(dependentId);
        return "redirect:/dependents/list";
    }
    @PostMapping("/save")
    public String saveDependent(@Valid @ModelAttribute("dependent") Dependent dependent, BindingResult bindingResult)
    {
        //System.out.println(dependent);
        if(bindingResult.hasErrors())
        {
            return "add-dependent";
        }
        else
        {
            dependentService.saveDependent(dependent);
            return "redirect:/dependents/list";
        }
    }

}
