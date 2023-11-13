package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.entity.Department;
import com.vtlamdev.business.business.entity.Dependent;
import com.vtlamdev.business.business.entity.Employee;
import com.vtlamdev.business.business.services.Department.DepartmentService;
import com.vtlamdev.business.business.services.Dependent.DependentService;
import com.vtlamdev.business.business.services.Employee.EmployeeService;
import com.vtlamdev.business.business.services.Job.JobService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    private JobService jobService;
    private DepartmentService departmentService;
    private DependentService dependentService;
    public EmployeeController(EmployeeService employeeService, JobService jobService, DepartmentService departmentService,DependentService dependentService)
    {
        this.employeeService=employeeService;
        this.jobService=jobService;
        this.departmentService=departmentService;
        this.dependentService=dependentService;
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
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        theModel.addAttribute("employee",new Employee());
        theModel.addAttribute("jobs",jobService.findAllJob());
        theModel.addAttribute("departments",departmentService.findAllDepartment());
        theModel.addAttribute("managers",employeeService.findAllEmplooyees());
        theModel.addAttribute("dependent",new Dependent());

        System.out.println(jobService.findAllJob());
        System.out.println(departmentService.findAllDepartment());
        System.out.println(employeeService.findAllEmplooyees());
        return "add-employee";
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "add-employee";
        }
        else
        {
            employeeService.addEmployee(employee);
            return "redirect:/employees/list";
        }
    }
    @GetMapping("/showFormForUpdate{employeeId}")
    public String showFormForUpdate(@RequestParam("employeeId") int employeeId,Model theModel)
    {
        theModel.addAttribute("employee", employeeService.findEmployeeById(employeeId));
        theModel.addAttribute("jobs",jobService.findAllJob());
        theModel.addAttribute("departments",departmentService.findAllDepartment());
        theModel.addAttribute("managers",employeeService.findAllEmplooyees());
        return "add-employee";
    }
    @GetMapping("/delete{employeeId}")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId)
    {
        employeeService.deleteEmployeeById(employeeId);
        return "redirect:/employees/list";
    }
}
