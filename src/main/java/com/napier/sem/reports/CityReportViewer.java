package com.napier.sem.reports;

import com.napier.sem.entities.City;
import com.napier.sem.services.CityService;

import java.util.ArrayList;


/**
 * Project Name: seMethods
 * Package: com.napier.sem.reports
 * User: Greg Ewens
 * Date Created: 19/02/2022 15:59
 * File Purpose: This class provides methods for viewing City reports
 */
@SuppressWarnings("PMD.SystemPrintln") // Prototype app using console for output
public class CityReportViewer {

    /**
     * An instance of the City repository class
     */
    private final CityService _cityService;

    /**
     * The public constructor
     * @param cityService Pass an instance of the City repository class
     */
    public CityReportViewer(CityService cityService){
        _cityService = cityService;
    }

    /**
     * Displays the details for a City with the given ID
     * @param Id The city Id to check
     */
    public void ShowCityDetails(int Id){
        var city = _cityService.getCityById(Id);

        System.out.println("Data found for city with Id: " + Id);

        displayCity(city, true);
    }

    /**
     * Displays all cities ordered by population
     */
    public void ShowCitiesByPopulation(){
        var cities = _cityService.getAllCitiesOrderedByPopulation();

        System.out.println("Report showing all cities ordered by population ascending");

        displayCities(cities);
    }

    /**
     * Displays all cities in a given country, ordered by population
     * @param countryCode The country code
     */
    public void ShowCitiesInCountryByPopulation(String countryCode){
        var cities = _cityService.getAllCitiesByCountryOrderedByPopulation(countryCode);

        System.out.println("Report showing all cities in " + countryCode + " ordered by population ascending");

        displayCities(cities);
    }

    /**
     * Displays all cities in a given district, ordered by population
     * @param districtName The district name
     */
    public void ShowCitiesInDistrictByPopulation(String districtName){
        var cities = _cityService.getAllCitiesByDistrictOrderedByPopulation(districtName);

        System.out.println("Report showing all cities in " + districtName + " ordered by population ascending");

        displayCities(cities);
    }

    /**
     * Displays all cities in a specified continent, ordered by population
     * @param continent The continent name
     */
    public void ShowCitiesInContinentByPopulation(String continent) {
        var cities = _cityService.getAllCitiesByContinentOrderedByPopulation(continent);

        System.out.println("Report showing all cities in " + continent + " ordered by population");

        displayCities(cities);
    }

    /**
     * Displays all cities in a specified region, ordered by population
     * @param region the region name
     */
    public void ShowCitiesInRegionByPopulation(String region) {
        var cities = _cityService.getAllCitiesByRegionOrderedByPopulation(region);

        System.out.println("Report showing all cities in " + region + " ordered by population");

        displayCities(cities);
    }

    /**
     * Shows the top N cities in the world where N is specified
     * @param n the number of cities to display
     */
    public void ShowTopNCitiesByPopulation(int n){
        var cities = _cityService.getTopNCitiesOrderedByPopulation(n);

        System.out.println("Report showing top " + n + " cities in ordered by population");

        displayCities(cities);
    }

    /**
     * Shows the top N cities in a specified district where N is specified
     * @param n the number of cities to show
     * @param districtName the name of the specified district
     */
    public void ShowTopNCitiesInDistrictByPopulation(int n, String districtName){
        var cities = _cityService.getTopNCitiesInDistrictOrderedByPopulation(n, districtName);

        System.out.println("Report showing top " + n + " cities in " + districtName + " ordered by population");

        displayCities(cities);
    }

    /**
     * Shows the top N cities in a specified continent where N is specified
     * @param n the number of cities to show
     * @param continentName the name of the specified continent
     */
    public void ShowTopNCitiesInContinentByPopulation(int n, String continentName){
        var cities = _cityService.getTopNCitiesInContinentOrderedByPopulation(n, continentName);

        System.out.println("Report showing top " + n + " cities in " + continentName + " ordered by population");

        displayCities(cities);
    }

    /**
     * Shows the top N cities in a specified region where N is specified
     * @param n the number of cities to show
     * @param regionName the name of the specified region
     */
    public void ShowTopNCitiesInRegionByPopulation(int n, String regionName){
        var cities = _cityService.getTopNCitiesInRegionOrderedByPopulation(n, regionName);

        System.out.println("Report showing top " + n + " cities in " + regionName + " ordered by population");

        displayCities(cities);
    }

    /**
     * Shows the top N cities in a specified district where N is specified
     * @param n the number of cities to show
     * @param countryName the name of the specified country
     */
    public void ShowTopNCitiesInCountryByPopulation(int n, String countryName){
        var cities = _cityService.getTopNCitiesInCountryOrderedByPopulation(n, countryName);

        System.out.println("Report showing top " + n + " cities in " + countryName + " ordered by population");

        displayCities(cities);
    }

    /**
     * Prints the details of a collection of cities
     * @param cities The collection of cities to display
     */
    private void displayCities(ArrayList<City> cities){
        displayCityHeader();

        for (var city: cities) {
            displayCity(city, false);
        }
    }

    /**
     * Prints the details of a single city
     * @param city The city to display
     */
    private void displayCity(City city, boolean showHeader)
    {
        if (showHeader){
            displayCityHeader();
        }

        if (city != null)
        {
            var row = String.format("%-6s %-36s %-13s %-20s %-10s",
                    city.id, city.name, city.countryCode, city.district, city.population);
            System.out.println(row);
        }
    }

    /**
     * Prints the column headers for city data
     */
    private void displayCityHeader(){
        var row = String.format("%-6s %-36s %-13s %-20s %-10s",
                "Id", "Name", "Country Code", "District", "Population");
        System.out.println(row);

    }
}
