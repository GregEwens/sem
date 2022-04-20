package com.napier.sem.helpers;

import com.napier.sem.entities.City;
import com.napier.sem.entities.Country;
import com.napier.sem.entities.SpokenLanguageJoinCountry;

import java.util.List;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.helpers
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:29
 * File Purpose: Helper methods for population and demographics
 */
public final class PopulationHelpers {

    /**
     * A private constructor because you can't just mark the class as static (c# > Java)
     */
    private PopulationHelpers(){

    }

    /**
     * calculates the total population from a collection of cities
     * @param cities the collection of cities
     * @return the total population as long
     */
    public static long sumCityPopulation(List<City> cities){
        long population = 0;

        for (var city:cities) {
            population += city.population;
        }

        return population;
    }

    /**
     * calculates the total population from a collection of countries
     * @param countries the collection of countries
     * @return the total population as long
     */
    public static long sumCountryPopulation(List<Country> countries){
        long population = 0;

        for (var country:countries) {
            population += country.population;
        }

        return population;
    }

    /**
     * calculates the total population from a collection of countries
     * @param countries the collection of countries
     * @return the total population as long
     */
    public static long sumLanguageCount(List<SpokenLanguageJoinCountry> countries){
        long population = 0;

        for (var country:countries) {
            population += country.population;
        }

        return population;
    }
}
