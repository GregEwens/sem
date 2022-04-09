package com.napier.sem.helpers;

import com.napier.sem.entities.City;
import com.napier.sem.entities.Country;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.helpers
 * User: <<Your name here>>
 * Date Created: 09/04/2022 14:29
 * File Purpose:
 */
public class populationHelpers {

    public static int sumCityPopulation(ArrayList<City> cities){
        var population = 0;

        for (var city:cities) {
            population += city.population;
        }

        return population;
    }

    public static int sumCountryPopulation(ArrayList<Country> countries){
        var population = 0;

        for (var country:countries) {
            population += country.Population;
        }

        return population;
    }
}
