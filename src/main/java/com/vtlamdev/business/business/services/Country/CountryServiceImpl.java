package com.vtlamdev.business.business.services.Country;

import com.vtlamdev.business.business.dao.Country.CountryRepository;
import com.vtlamdev.business.business.dao.Country.CustomCountryRepository;
import com.vtlamdev.business.business.entity.Country;
import com.vtlamdev.business.business.services.Country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
    private CustomCountryRepository customCountryRepository;
    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, CustomCountryRepository customCountryRepository)
    {
        this.countryRepository=countryRepository;
        this.customCountryRepository=customCountryRepository;
    }

    @Override
    @Transactional
    public List<Country> findAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional
    public Country findCountryById(String id) {
        Optional<Country> result=countryRepository.findById(id);
        Country theCountry;
        if(result.isPresent())
        {
            theCountry=result.get();
        }
        else
        {
            throw new RuntimeException("Didn't find Coutry with id = "+id);
        }
        return theCountry;
    }

    @Override
    @Transactional
    public Country saveCountry(Country country) {
        Country theCountry=countryRepository.save(country);
        return theCountry;
    }

    @Override
    @Transactional
    public void deleteCountryById(String id) {
        countryRepository.deleteById(id);
    }
    @Override
    @Transactional
    public List<Country> findAllCountriesAndLocationByJoinFetch()
    {
        return customCountryRepository.findAllCountriesAndLocationByJoinFetch();
    }
}
