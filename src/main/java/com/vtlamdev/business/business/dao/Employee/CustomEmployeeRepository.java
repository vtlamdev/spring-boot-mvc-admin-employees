package com.vtlamdev.business.business.dao.Employee;

import com.vtlamdev.business.business.entity.Employee;

import java.util.List;

public interface CustomEmployeeRepository {
    List<Employee> findAllEmployeeAndDependentByJoinFetch();
}
