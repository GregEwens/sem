package com.napier.sem.services;

import com.napier.sem.entities.City;
import com.napier.sem.repositories.ICityRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.services
 * User: Laura Main
 * Date Created: 12/03/2022 13:14
 * File Purpose:Processes business logic for City reports
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
    public City getCityById(int ID) {
        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        return cities.stream().filter(c -> c.id == ID).collect(Collectors.toList()).get(0);
    }

    /**
     * Gets a collection of cities found in the specified continent
     * @param continentName The continent to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByContinentOrderedByPopulation(String continentName) {

        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInContinent = new ArrayList<City>();

        for (var city:cities) {
            if (city.continent.equalsIgnoreCase(continentName)){
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
    public ArrayList<City> getAllCitiesByRegionOrderedByPopulation(String regionName) {
        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInRegion = new ArrayList<City>();

        for (var city:cities) {
            if (city.region.equalsIgnoreCase(regionName)){
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
     * Gets the top N cities in a specified region ordered by population where N is specified
     * @param n The number of cities to return
     * @param regionName the name of the specified region
     * @return A collection of cities
     */
    public ArrayList<City> getTopNCitiesInRegionOrderedByPopulation(int n, String regionName){

        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInRegion = new ArrayList<City>();

        for (var city:cities) {
            if (city.region.equalsIgnoreCase(regionName)){
                citiesInRegion.add(city);
            }
        }

        return (ArrayList<City>) citiesInRegion.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets the top N cities in a specified country ordered by population where N is specified
     * @param n The number of cities to return
     * @param countryName the name of the specified country
     * @return A collection of cities
     */
    public ArrayList<City> getTopNCitiesInCountryOrderedByPopulation(int n, String countryName){

        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInCountry = new ArrayList<City>();

        for (var city:cities) {
            if (city.countryName.equalsIgnoreCase(countryName)){
                citiesInCountry.add(city);
            }
        }

        return (ArrayList<City>) citiesInCountry.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets the top N cities in a specified continent ordered by population where N is specified
     * @param n The number of cities to return
     * @param continentName the name of the specified continent
     * @return A collection of cities
     */
    public ArrayList<City> getTopNCitiesInContinentOrderedByPopulation(int n, String continentName){

        var cities = _cityRepository.getAllCitiesJoinCountryOrderedByPopulation();

        var citiesInContinent = new ArrayList<City>();

        for (var city:cities) {
            if (city.continent.equalsIgnoreCase(continentName)){
                citiesInContinent.add(city);
            }
        }

        return (ArrayList<City>) citiesInContinent.stream().limit(n).collect(Collectors.toList());    }

    /**
     * Gets the top N cities in a specified district ordered by population where N is specified
     * @param n The number of cities to return
     * @param districtName the name of the specified district
     * @return A collection of cities
     */
    public ArrayList<City> getTopNCitiesInDistrictOrderedByPopulation(int n, String districtName){

        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        var citiesInDistrict = new ArrayList<City>();

        for (var city:cities) {
            if (city.district.equalsIgnoreCase(districtName)){
                citiesInDistrict.add(city);
            }
        }

        return (ArrayList<City>) citiesInDistrict.stream().limit(n).collect(Collectors.toList());
    }

    /**
     * Gets a collection of all cities
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesOrderedByPopulation() {
        return _cityRepository.getAllCitiesOrderedByPopulation();
    }

    /**
     * Gets a single city by name
     * @param cityName the name of the specified city
     * @return a city or null
     */
    public City getCityByName(String cityName) {
        var cities = _cityRepository.getAllCitiesOrderedByPopulation();

        for (var city:cities) {
            if (city.name.equalsIgnoreCase(cityName)){
                return city;
            }
        }

        return null;
    }
}
