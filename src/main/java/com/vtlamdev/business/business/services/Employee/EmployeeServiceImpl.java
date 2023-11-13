package com.vtlamdev.business.business.services.Employee;

import com.vtlamdev.business.business.dao.Employee.CustomEmployeeRepository;
import com.vtlamdev.business.business.dao.Employee.EmployeeRepository;
import com.vtlamdev.business.business.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private CustomEmployeeRepository customEmployeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CustomEmployeeRepository customEmployeeRepository)
    {
        this.employeeRepository=employeeRepository;
        this.customEmployeeRepository=customEmployeeRepository;
    }

    @Override
    @Transactional
    public List<Employee> findAllEmplooyees() {
        return employeeRepository.findAll();
    }
    @Override
    @Transactional
    public List<Employee> findAllEmployeeAndDependentByJoinFetch()
    {
        return customEmployeeRepository.findAllEmployeeAndDependentByJoinFetch();
    }
    @Override
    @Transactional
    public Employee findEmployeeById(int id)
    {
        Optional<Employee> employee=employeeRepository.findById(id);
        return employee.get();
    }
    @Override
    @Transactional
    public Employee addEmployee(Employee employee)
    {
        return  employeeRepository.save(employee);
    }
    @Override
    @Transactional
    public void deleteEmployeeById(int id)
    {
        employeeRepository.deleteById(id);
    }
}
