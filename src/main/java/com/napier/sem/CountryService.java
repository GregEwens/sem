package com.napier.sem;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: <<Your name here>>
 * Date Created: 11/03/2022 10:50
 * File Purpose:
 */
public class CountryService {


    private final ICountryRepository _countryRepoitory;

    public CountryService(ICountryRepository countryRepository){
        _countryRepoitory = countryRepository;
    }

    /**
     * Gets all countries in a region, ordered by population high to low.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    public ArrayList<Country> getAllCountriesInRegionOrderedByPopulation(String regionName)
    {

        var countries = _countryRepoitory.getAllCountriesOrderByPopulation();

        var countriesInRegion = new ArrayList<Country>();

        for (var country:countries) {
            if (country.Region.equalsIgnoreCase(regionName)){
                countriesInRegion.add(country);
            }
        }

        return countriesInRegion;
    }

    /**
     * Gets all countries in a continent, ordered by population high to low.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    public ArrayList<Country> getAllCountriesInContinentOrderedByPopulation(String continentName)
    {

        var countries = _countryRepoitory.getAllCountriesOrderByPopulation();

        var countriesInContinent = new ArrayList<Country>();

        for (var country:countries) {
            if (country.Continent.equalsIgnoreCase(continentName)){
                countriesInContinent.add(country);
            }
        }

        return countriesInContinent;
    }

    /**
     * Gets the top N countries ordered by population where N is specified
     * @param n The number of countries to return
     * @return A collection of countries
     */
    public ArrayList<Country> getTopNCountriesOrderedByPopulation(int n){
        var countries = _countryRepoitory.getAllCountriesOrderByPopulation();

        return (ArrayList<Country>) countries.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets all countries, ordered by population high to low.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    public ArrayList<Country> getAllCountriesOrderByPopulation() {
        return _countryRepoitory.getAllCountriesOrderByPopulation();
    }
}