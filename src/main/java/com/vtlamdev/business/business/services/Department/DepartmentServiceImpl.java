package com.vtlamdev.business.business.services.Department;

import com.vtlamdev.business.business.dao.DepartmentRepository;
import com.vtlamdev.business.business.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository)
    {
        this.departmentRepository=departmentRepository;
    }
    @Autowired
    @Transactional
    public List<Department> findAllDepartment()
    {
        return departmentRepository.findAll();
    }
}
