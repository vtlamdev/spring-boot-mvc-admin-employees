package com.vtlamdev.business.business.services.Region;

import com.vtlamdev.business.business.dao.Region.RegionRepository;
import com.vtlamdev.business.business.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RegionServiceImpl implements RegionService{
    private RegionRepository regionRepository;
    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository)
    {
        this.regionRepository=regionRepository;
    }
    @Override
    @Transactional
    public List<Region> findAllRegion() {
        return regionRepository.findAll();
    }
}
