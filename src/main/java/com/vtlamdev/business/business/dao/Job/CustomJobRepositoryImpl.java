package com.vtlamdev.business.business.dao.Job;

import com.vtlamdev.business.business.entity.Job;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EnumType;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomJobRepositoryImpl implements CustomJobRepository{
    private EntityManager entityManager;
    @Autowired
    public CustomJobRepositoryImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    public Job findJobAndEmployeesByJoinFetch(int id)
    {
        TypedQuery<Job> query=entityManager.createQuery("from Job j join fetch j.employees where j.id=:param",Job.class);
        query.setParameter("param",id);
        return query.getSingleResult();
    }
}
