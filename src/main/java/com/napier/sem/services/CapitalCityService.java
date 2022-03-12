package com.napier.sem.services;

import com.napier.sem.entities.CapitalCity;
import com.napier.sem.repositories.ICapitalCityRepository;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Laura Main
 * Date Created: 12/03/2022 13:43
 * File Purpose: Processes business logic for Capital City reports
 */
public class CapitalCityService {

    /**
     * The Capital City Repository
     */
    private final ICapitalCityRepository _capitalCityRepository;

    /**
     * The public constructor
     * @param capitalCityRepository An instance of the CapitalCityRepository
     */
    public CapitalCityService(ICapitalCityRepository capitalCityRepository){
        _capitalCityRepository = capitalCityRepository;
    }

    /**
     * Gets a collection of capital cities found in the specified continent
     * @param continentName The continent to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<CapitalCity> getAllCapitalCitiesByContinentOrderedByPopulation(String continentName){
        var cities = _capitalCityRepository.getAllCapitalCitiesOrderedByPopulation();


        var citiesInContinent = new ArrayList<CapitalCity>();

        for (var city:cities) {
            if (city.Continent.equalsIgnoreCase(continentName)){
                citiesInContinent.add(city);
            }
        }

        return citiesInContinent;
    }
}
