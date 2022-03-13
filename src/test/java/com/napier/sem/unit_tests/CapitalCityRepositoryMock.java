package com.napier.sem.unit_tests;

import com.napier.sem.entities.CapitalCity;
import com.napier.sem.entities.City;
import com.napier.sem.repositories.ICapitalCityRepository;

import java.util.ArrayList;

public class CapitalCityRepositoryMock implements ICapitalCityRepository {
    @Override
    public ArrayList<CapitalCity> getAllCapitalCitiesOrderedByPopulation() {
        var cities = new ArrayList<CapitalCity>();

        for (int i = 0; i < 30; i++) {
            var city = new CapitalCity();

            var continent = "South America";  // 15 south america
            if(i >= 15) continent = "Oceania"; // 15 oceania

            // generate values based on index
            city.country = Integer.toString(i);
            city.population = (int) Math.pow(2, i);
            city.Continent = continent;
            city.name = "name" + i;

            cities.add(city);
        }

        return cities;
    }
}
