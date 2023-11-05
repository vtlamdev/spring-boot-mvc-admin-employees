package com.vtlamdev.business.business.dao.Employee;

import com.vtlamdev.business.business.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository{
    private EntityManager entityManager;
    @Autowired
    public CustomEmployeeRepositoryImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAllEmployeeAndDependentByJoinFetch()
    {
        TypedQuery<Employee> query=entityManager.createQuery("from Employee  e join fetch e.dependent",Employee.class);
        return query.getResultList();
    }
}
