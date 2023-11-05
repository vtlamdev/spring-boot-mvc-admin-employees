package com.vtlamdev.business.business.dao.Employee;

import com.vtlamdev.business.business.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
