package com.vtlamdev.business.business.dao.Country;

import com.vtlamdev.business.business.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,String> {
}
