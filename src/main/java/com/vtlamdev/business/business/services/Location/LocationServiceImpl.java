package com.vtlamdev.business.business.services.Location;

import com.vtlamdev.business.business.dao.Location.LocationRepository;
import com.vtlamdev.business.business.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{
    private LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository)
    {
        this.locationRepository=locationRepository;
    }

    @Override
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
