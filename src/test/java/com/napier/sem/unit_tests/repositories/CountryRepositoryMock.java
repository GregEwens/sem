package com.napier.sem.unit_tests.repositories;

import com.napier.sem.entities.Country;
import com.napier.sem.repositories.ICountryRepository;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 11/03/2022 11:11
 * File Purpose: Mockup of CountryRepository
 */
public class CountryRepositoryMock implements ICountryRepository {

    /**
     * Mockup of getAllCountriesOrderByPopulation.
     * @return This method returns 30 countries with values based on index
     */
    @Override
    public ArrayList<Country> getAllCountriesOrderByPopulation() {
        var countries = new ArrayList<Country>();

        for (int i = 0; i < 30; i++) {
            var country = new Country();

            var continent = "Europe";  // 15 europe
            if(i > 15) continent = "Asia"; // 15 Asia

            var region = "North Africa";  // 15 europe
            if(i > 15) region = "West Africa"; // 15 Asia

            // generate values based on index
            country.continent = continent;
            country.code = "CD" + i;
            country.population = Integer.MAX_VALUE - (int) Math.pow(2, i);
            country.region = region;
            country.capital = "City" + i;
            country.name = "Country" + i;
            country.gnp = BigDecimal.valueOf(Math.pow(2, i) + 1000);
            country.gnpOld = BigDecimal.valueOf(Math.pow(2, i) + 2000);
            country.governmentForm = "GovernmentForm" + i;
            country.headOfState = "Head of State" + i;
            country.indepYear = (short) (1000 + (i * 3));
            country.lifeExpectancy = new BigDecimal(100 - i);
            country.localName = "Local Name" + i;
            country.surfaceArea = BigDecimal.valueOf(Math.pow(2, i) - 10000);

            countries.add(country);
        }

        return countries;
    }
}
