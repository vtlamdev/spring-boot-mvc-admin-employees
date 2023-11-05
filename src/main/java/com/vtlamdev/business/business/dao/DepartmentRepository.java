package com.vtlamdev.business.business.dao;

import com.vtlamdev.business.business.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
