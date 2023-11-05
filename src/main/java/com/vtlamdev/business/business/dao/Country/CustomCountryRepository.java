package com.vtlamdev.business.business.dao.Country;

import com.vtlamdev.business.business.entity.Country;

import java.util.List;

public interface CustomCountryRepository {
    List<Country> findAllCountriesAndLocationByJoinFetch();
}
