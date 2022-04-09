package com.napier.sem.helpers;

import com.napier.sem.entities.City;
import com.napier.sem.entities.Country;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.helpers
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:29
 * File Purpose:
 */
public class PopulationHelpers {

    public static long sumCityPopulation(ArrayList<City> cities){
        long population = 0;

        for (var city:cities) {
            population += city.population;
        }

        return population;
    }

    public static long sumCountryPopulation(ArrayList<Country> countries){
        long population = 0;

        for (var country:countries) {
            population += country.Population;
        }

        return population;
    }
}
