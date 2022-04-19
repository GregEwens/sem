package com.napier.sem.reports;

import com.napier.sem.entities.Country;
import com.napier.sem.services.CountryService;
import java.util.ArrayList;


/**
 * Project Name: seMethods
 * Package: com.napier.sem.reports
 * User: Greg Ewens
 * Date Created: 19/02/2022 15:28
 * File Purpose: This class provides methods for viewing Country reports
 */
@SuppressWarnings("PMD.SystemPrintln") // Prototype app using console for output
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
     * Displays top n countries in a specified continent ordered by population
     * @param n The number of countries to show
     * @param continentName The specified continent
     */
    public void ShowTopNCountriesInContinentByPopulation(int n, String continentName){
        var countries = _countryService.getTopNCountriesInContinentOrderedByPopulation(n, continentName);

        System.out.println("Report showing top " + n + " countries in " + continentName + " ordered by population " +
                "ascending");

        displayCountries(countries);
    }

    /**
     * Displays top n countries in a specified region ordered by population
     * @param n The number of countries to show
     * @param regionName The specified region
     */
    public void ShowTopNCountriesInRegionByPopulation(int n, String regionName){
        var countries = _countryService.getTopNCountriesInContinentOrderedByPopulation(n, regionName);

        System.out.println("Report showing top " + n + " countries in " + regionName + " ordered by population " +
                "ascending");

        displayCountries(countries);
    }

    /**
     * Prints the details of a collection of countries
     * @param countries The collection of countries to display
     */
    private void displayCountries(ArrayList<Country> countries){

        var header = String.format("%-13s %-53s %-14s %-27s %-10s %-36s",
                "Country Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println(header);

        for (var country: countries) {
            displayCountry(country);
        }
    }

    /**
     * Prints the details of a single country
     * @param country The country to display
     */
    private void displayCountry(Country country)
    {
        if (country != null)
        {
            var row = String.format("%-13s %-53s %-14s %-27s %-10s %-36s",
                    country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital);
            System.out.println(row);
        }
    }
}
