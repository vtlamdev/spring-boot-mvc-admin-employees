package com.vtlamdev.business.business.services.Country;

import com.vtlamdev.business.business.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAllCountry();
    Country findCountryById(String id);
    Country saveCountry(Country country);
    void deleteCountryById(String id);
    List<Country> findAllCountriesAndLocationByJoinFetch();
}
