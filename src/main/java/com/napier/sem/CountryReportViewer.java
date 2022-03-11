/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 19/02/2022 15:28
 * File Purpose: This class provides methods for viewing Country reports
 */

package com.napier.sem;

import java.util.ArrayList;

public class CountryReportViewer {

    /**
     * An instance of the Country repository class
     */
    private final CountryService _countryService;

    /**
     * The public constructor
     * @param countryService Pass an instance of the Country service class
     */
    public CountryReportViewer(CountryService countryService){

        this._countryService = countryService;
    }

    /**
     * Displays all country ordered by population
     */
    public void ShowCountriesByPopulation(){
        var countries = _countryService.getAllCountriesOrderByPopulation();

        System.out.println("Report showing all countries ordered by population ascending");

        displayCountries(countries);
    }

    /**
     * Displays all countries in a region ordered by population
     * @param regionName The region name
     */
    public void ShowCountriesInARegionByPopulation(String regionName){
        var countries = _countryService.getAllCountriesInRegionOrderedByPopulation(regionName);

        System.out.println("Report showing all countries in region " + regionName + " ordered by population ascending");

        displayCountries(countries);
    }

    /**
     * Displays all countries in a continent ordered by population
     * @param continentName The continent name
     */
    public void ShowCountriesInAContinentByPopulation(String continentName){
        var countries = _countryService.getAllCountriesInContinentOrderedByPopulation(continentName);

        System.out.println("Report showing all countries in continent " + continentName + " ordered by population ascending");

        displayCountries(countries);
    }

    /**
     * Displays top n countries ordered by population
     * @param n The number of countries to show
     */
    public void ShowTopNCountriesByPopulation(int n){
        var countries = _countryService.getTopNCountriesOrderedByPopulation(n);

        System.out.println("Report showing top " + n + " countries ordered by population " +
                "ascending");

        displayCountries(countries);
    }

    /**
     * Prints the details of a collection of countries
     * @param countries The collection of countries to display
     */
    private void displayCountries(ArrayList<Country> countries){
        for (var country: countries) {
            displayCountry(country);
        }
    }

    /**
     * Prints the details of a single country
     * @param ctry The country to display
     */
    private void displayCountry(Country ctry)
    {
        if (ctry != null)
        {
            System.out.println(
                    ctry.Code + " "
                            + ctry.Name + " "
                            + ctry.Continent + "\n"
                            + ctry.Region + "\n"
                            + "Population:" + ctry.Population + "\n" +
                            ctry.Capital + "\n");
        }
    }

}
