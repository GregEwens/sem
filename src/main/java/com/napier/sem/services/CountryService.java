package com.napier.sem.services;

import com.napier.sem.entities.Country;
import com.napier.sem.repositories.ICountryRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.services
 * User: Laura Main
 * Date Created: 11/03/2022 10:50
 * File Purpose:Processes business logic for Country reports
 */
public class CountryService {

    /**
     * The country repository
     */
    private final ICountryRepository _countryRepoitory;

    /**
     * The public constructor
     * @param countryRepository The repository for Country data
     */
    public CountryService(ICountryRepository countryRepository){
        _countryRepoitory = countryRepository;
    }

    /**
     * Gets all countries in a region, ordered by population high to low.
     * @param regionName the name of the specified region
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
     * @param continentName the name of the specified continent
     * @return A list of all countries, the collection may be empty should no countries be found.
     *
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
     * Gets the top N countries in a specified continent ordered by population where N is specified
     * @param n The number of countries to return
     * @param continentName the name of the specified continent
     * @return A collection of countries
     */
    public ArrayList<Country> getTopNCountriesInContinentOrderedByPopulation(int n, String continentName){

        var countries = _countryRepoitory.getAllCountriesOrderByPopulation();

        var countriesInContinent = new ArrayList<Country>();

        for (var country:countries) {
            if (country.Continent.equalsIgnoreCase(continentName)){
                countriesInContinent.add(country);
            }
        }

        return (ArrayList<Country>) countriesInContinent.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets the top N countries in a specified region ordered by population where N is specified
     * @param n The number of countries to return
     * @param regionName the name of the specified region
     * @return A collection of countries
     */
    public ArrayList<Country> getTopNCountriesInRegionOrderedByPopulation(int n, String regionName){

        var countries = _countryRepoitory.getAllCountriesOrderByPopulation();

        var countriesInRegion = new ArrayList<Country>();

        for (var country:countries) {
            if (country.Region.equalsIgnoreCase(regionName)){
                countriesInRegion.add(country);
            }
        }

        return (ArrayList<Country>) countriesInRegion.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets all countries, ordered by population high to low.
     * @return A list of all countries, the collection may be empty should no countries be found.
     */
    public ArrayList<Country> getAllCountriesOrderByPopulation() {
        return _countryRepoitory.getAllCountriesOrderByPopulation();
    }

    /**
     * Gets a single country by name
     * @param countryName the name of the specified country
     * @return a country or null
     */
    public Country getCountryByName(String countryName) {

        var countries = _countryRepoitory.getAllCountriesOrderByPopulation();

        for (var country:countries) {
            if (country.Name.equalsIgnoreCase(countryName)){
                return country;
            }
        }

        return null;
    }
}
