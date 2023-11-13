package com.vtlamdev.business.business.services.Employee;

import com.vtlamdev.business.business.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmplooyees();
    Employee findEmployeeById(int id);
    Employee addEmployee(Employee employee);
    void deleteEmployeeById(int id);
    List<Employee> findAllEmployeeAndDependentByJoinFetch();
}
