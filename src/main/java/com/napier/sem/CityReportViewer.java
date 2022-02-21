/**
 * Placeholder for file header...
 */

package com.napier.sem;

import java.util.ArrayList;

/**
 * This class provides methods for viewing City reports
 */
public class CityReportViewer {

    /**
     * An instance of the City repository class
     */
    private final CityRepository cityRepository;

    /**
     * The public constructor
     * @param cityRepo Pass an instance of the City repository class
     */
    public CityReportViewer(CityRepository cityRepo){
        this.cityRepository = cityRepo;
    }

    /**
     * Displays the details for a City with the given ID
     * @param Id The city Id to check
     */
    public void ShowCityDetails(int Id){
        var city = cityRepository.getCityById(Id);

        System.out.println("Data found for city with Id: " + Id);

        displayCity(city);
    }

    /**
     * Displays all cities ordered by population
     */
    public void ShowCitiesByPopulation(){
        var cities = cityRepository.getAllCitiesOrderedByPopulation();

        System.out.println("Report showing all cities ordered by population ascending");

        displayCities(cities);
    }

    /**
     * Displays all cities in a given continent, ordered by population
     * @param continent The continent
     * @param sortOrder The sort order.
     */
    public void ShowCapitalCitiesInContinentByPopulation(String continent, SortOrder sortOrder){
        var cities = cityRepository.getAllCapitalCitiesByContinentOrderedByPopulation(continent, sortOrder);

        System.out.println("Report showing all capital cities in " + continent + " ordered by population " + sortOrder);

        for (var city: cities) {
            if (city != null)
            {
                System.out.println(
                                city.name + ", "
                                + city.country + "\n"
                                + "Population:" + city.population + "\n");
            }
        }
    }

    /**
     * Displays all cities in a given country, ordered by population
     * @param countryCode The country code
     */
    public void ShowCitiesInCountryByPopulation(String countryCode){
        var cities = cityRepository.getAllCitiesByCountryOrderedByPopulation(countryCode);

        System.out.println("Report showing all cities in " + countryCode + " ordered by population ascending");

        displayCities(cities);
    }

    /**
     * Displays all cities in a given district, ordered by population
     * @param districtName The district name
     */
    public void ShowCitiesInDistrictByPopulation(String districtName){
        var cities = cityRepository.getAllCitiesByDistrictOrderedByPopulation(districtName);

        System.out.println("Report showing all cities in " + districtName + " ordered by population ascending");

        displayCities(cities);
    }

    public void ShowCitiesInContinentByPopulation(String continent, SortOrder sortOrder) {
        var cities = cityRepository.getAllCitiesByContinentOrderedByPopulation(continent, sortOrder);

        System.out.println("Report showing all cities in " + continent + " ordered by population sort order " + sortOrder);

        displayCities(cities);
    }

    public void ShowCitiesInRegionByPopulation(String region, SortOrder sortOrder) {
        var cities = cityRepository.getAllCitiesByRegionOrderedByPopulation(region, sortOrder);

        System.out.println("Report showing all cities in " + region + " ordered by population sort order " + sortOrder);

        displayCities(cities);
    }

    /**
     * Prints the details of a collection of cities
     * @param cities The collection of cities to display
     */
    private void displayCities(ArrayList<City> cities){
        for (var city: cities) {
            displayCity(city);
        }
    }

    /**
     * Prints the details of a single city
     * @param cty The city to display
     */
    private void displayCity(City cty)
    {
        if (cty != null)
        {
            System.out.println(
                    cty.id + " "
                            + cty.name + " "
                            + cty.countryCode + "\n"
                            + cty.district + "\n"
                            + "Population:" + cty.population + "\n");
        }
    }
}
