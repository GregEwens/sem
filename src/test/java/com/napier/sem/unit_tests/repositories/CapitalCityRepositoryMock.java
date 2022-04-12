package com.napier.sem.unit_tests.repositories;

import com.napier.sem.entities.CapitalCity;
import com.napier.sem.repositories.ICapitalCityRepository;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.unit_tests
 * User: Greg Ewens
 * Date Created: 12/03/2022 14:45
 * File Purpose: Mockup of CapitalCityRepository
 */
public class CapitalCityRepositoryMock implements ICapitalCityRepository {

    /**
     * Mockup of getAllCitiesOrderedByPopulation.
     * @return This method returns 30 capital cities with values based on index
     */
    @Override
    public ArrayList<CapitalCity> getAllCapitalCitiesOrderedByPopulation() {
        var cities = new ArrayList<CapitalCity>();

        for (int i = 0; i < 30; i++) {
            var city = new CapitalCity();

            var continent = "South America";  // 15 south america
            if(i >= 15) continent = "Oceania"; // 15 oceania

            var region = "Caribbean"; // 15 Caribbean
            if(i >= 15) region = "Middle East"; // 15 Middle East

            // generate values based on index
            city.country = Integer.toString(i);
            city.population = 10000000-(int) Math.pow(2, i);
            city.Continent = continent;
            city.name = "name" + i;
            city.region = region;

            cities.add(city);
        }

        return cities;
    }
}
