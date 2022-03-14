package com.napier.sem.reports;

import com.napier.sem.entities.CapitalCity;
import com.napier.sem.services.CapitalCityService;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.reports
 * User: Laura Main
 * Date Created: 12/03/2022 13:40
 * File Purpose: This class provides methods for viewing Capital City reports
 */
public class CapitalCityReportViewer {


    /**
     * An instance of the City service class
     */
    private final CapitalCityService _capitalCityService;

    /**
     * The public constructor
     * @param capitalCityService Pass an instance of the capital City service class
     */
    public CapitalCityReportViewer(CapitalCityService capitalCityService){
        _capitalCityService = capitalCityService;
    }

    /**
     * Displays all capital cities in a given continent, ordered by population
     * @param continent The continent
     */
    public void ShowCapitalCitiesInContinentByPopulation(String continent){
        var cities = _capitalCityService.getAllCapitalCitiesByContinentOrderedByPopulation(continent);

        System.out.println("Report showing all capital cities in " + continent + " ordered by population");

        displayCapitalCities(cities);
    }

    /**
     * Prints the details of a collection of capital cities
     * @param cities The collection of capital cities to display
     */
    private void displayCapitalCities(ArrayList<CapitalCity> cities){
        for (var city: cities) {
            displayCapitalCity(city);
        }
    }

    /**
     * Prints the details of a single capital city
     * @param city The capital city to display
     */
    private void displayCapitalCity(CapitalCity city){
        if (city != null)
        {
            System.out.println(
                    city.name + ", "
                            + city.country + "\n"
                            + "Population:" + city.population + "\n");
        }
    }
}
