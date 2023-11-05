package com.vtlamdev.business.business.services.Dependent;

import com.vtlamdev.business.business.dao.DependentRepository;
import com.vtlamdev.business.business.entity.Dependent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DependentServiceImpl implements DependentService{
    private DependentRepository dependentRepository;
    @Autowired
    public DependentServiceImpl(DependentRepository dependentRepository)
    {
        this.dependentRepository=dependentRepository;
    }

    @Override
    @Transactional
    public List<Dependent> findAllDependents() {
        return dependentRepository.findAll();
    }

    @Override
    @Transactional
    public Dependent findDependentById(int id) {
        Optional<Dependent> dependent=dependentRepository.findById(id);
        return dependent.get();
    }

    @Override
    @Transactional
    public Dependent saveDependent(Dependent dependent) {
        return dependentRepository.save(dependent);
    }

    @Override
    @Transactional
    public void deleteDependentById(int id) {
        dependentRepository.deleteById(id);
    }
}
