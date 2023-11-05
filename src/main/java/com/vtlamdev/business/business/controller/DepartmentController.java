package com.vtlamdev.business.business.controller;

import com.vtlamdev.business.business.services.Department.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("departments")
public class DepartmentController {
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService=departmentService;
    }
    @GetMapping("/list")
    public String listdepartments(Model theModel)
    {
        theModel.addAttribute("departments",departmentService.findAllDepartment());
        return "list-department";
    }
}
