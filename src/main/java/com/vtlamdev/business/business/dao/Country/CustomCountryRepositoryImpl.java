package com.vtlamdev.business.business.dao.Country;

import com.vtlamdev.business.business.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CustomCountryRepositoryImpl implements CustomCountryRepository{
    private EntityManager entityManager;
    @Autowired
    public CustomCountryRepositoryImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public List<Country> findAllCountriesAndLocationByJoinFetch()
    {
        TypedQuery<Country> theQuery=entityManager.createQuery("from Country c left join c.locations ",Country.class);
        return theQuery.getResultList();
    }
}
