package com.vtlamdev.business.business.services.Dependent;

import com.vtlamdev.business.business.entity.Dependent;

import java.util.List;

public interface DependentService {
    List<Dependent> findAllDependents();
    Dependent findDependentById(int id);
    Dependent saveDependent(Dependent dependent);
    void deleteDependentById(int id);

}
