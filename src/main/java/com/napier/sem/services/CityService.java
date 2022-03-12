package com.napier.sem.services;

import com.napier.sem.entities.City;
import com.napier.sem.entities.Country;
import com.napier.sem.repositories.ICityRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: <<Your name here>>
 * Date Created: 12/03/2022 13:14
 * File Purpose:
 */
public class CityService {

    /**
     * The city repository
     */
    private final ICityRepository _cityRepository;

    /**
     * The public constructor
     * @param cityRepository The repository for City data
     */
    public CityService(ICityRepository cityRepository){
        _cityRepository = cityRepository;
    }

    /**
     * Returns a single instance of City from the city ID
     * @param ID The city ID
     * @return The instance of city found or null
     */
    public City getCityById(int ID)
    {
        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        var city = cities.stream().filter(c -> c.id == ID).collect(Collectors.toList()).get(0);

        return city;
    }

    /**
     * Gets a collection of cities found in the specified continent
     * @param continentName The continent to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByContinentOrderedByPopulation(String continentName)
    {

        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInContinent = new ArrayList<City>();

        for (var city:cities) {
            if (city.Continent.equalsIgnoreCase(continentName)){
                citiesInContinent.add(city);
            }
        }

        return citiesInContinent;
    }

    /**
     * Gets a collection of cities found in the specified region
     * @param regionName The region to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByRegionOrderedByPopulation(String regionName)
    {
        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInRegion = new ArrayList<City>();

        for (var city:cities) {
            if (city.Region.equalsIgnoreCase(regionName)){
                citiesInRegion.add(city);
            }
        }

        return citiesInRegion;
    }

    /**
     * Gets a collection of cities found in the specified country
     * @param countryCode The countryCode to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByCountryOrderedByPopulation(String countryCode){
        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        var citiesInCountry = new ArrayList<City>();

        for (var city:cities) {
            if (city.countryCode.equalsIgnoreCase(countryCode)){
                citiesInCountry.add(city);
            }
        }

        return citiesInCountry;
    }

    /**
     * Gets a collection of cities found in a given region
     * @param districtName The region name to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByDistrictOrderedByPopulation(String districtName){
        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        var citiesInDistrict = new ArrayList<City>();

        for (var city:cities) {
            if (city.district.equalsIgnoreCase(districtName)){
                citiesInDistrict.add(city);
            }
        }

        return citiesInDistrict;
    }

    /**
     * Gets the top N cities ordered by population where N is specified
     * @param n The number of cities to show
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getTopNCitiesOrderedByPopulation(int n){
        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        return (ArrayList<City>) cities.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets a collection of all cities
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesOrderedByPopulation() {
        return _cityRepository.getAllCitiesOrderedByPopulation();
    }
}
