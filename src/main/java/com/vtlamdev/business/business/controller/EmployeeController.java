package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.services.Employee.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService=employeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel)
    {
        theModel.addAttribute("employees",employeeService.findAllEmplooyees());
        return "list-employees";
    }
    @GetMapping("/employee{employeeId}")
    public String findEmployeeById(@RequestParam("employeeId") int employeeId, Model theModel)
    {
        theModel.addAttribute("employees", employeeService.findEmployeeById(employeeId));
        return "list-employees";
    }
}
