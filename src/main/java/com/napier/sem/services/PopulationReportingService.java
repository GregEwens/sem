package com.napier.sem.services;

import com.napier.sem.entities.City;
import com.napier.sem.models.HighLevelPopulationReportModel;
import static com.napier.sem.helpers.PopulationHelpers.sumCityPopulation;
import static com.napier.sem.helpers.PopulationHelpers.sumCountryPopulation;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.services
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:06
 * File Purpose:Processes business logic for Population reporting
 */
public class PopulationReportingService {

    /**
     * The country repository
     */
    private final CountryService _countryService;

    /**
     * The city repository
     */
    private final CityService _cityService;

    /**
     * The public constructor
     * @param countryService The repository for Country data
     * @param cityService The repository for City data
     */
    public PopulationReportingService(CountryService countryService, CityService cityService ){
        _countryService = countryService;
        _cityService = cityService;
    }

    /**
     * Gets a HighLevelPopulationReportModel for a specified continent
     * @param continentName the Continent name
     * @return a HighLevelPopulationReportModel
     */
    public HighLevelPopulationReportModel getHighLevelPopulationDataForContinent(String continentName){

        var allCitiesInContinent = _cityService.getAllCitiesByContinentOrderedByPopulation(continentName);
        var allCountriesInContinent = _countryService.getAllCountriesInContinentOrderedByPopulation(continentName);

        if (allCountriesInContinent.size() == 0) return null;

        var model = new HighLevelPopulationReportModel();
        model.Name = continentName;
        model.Population = sumCountryPopulation(allCountriesInContinent);
        model.CityPopulation = sumCityPopulation(allCitiesInContinent);

        return model;
    }

    /**
     * Gets a HighLevelPopulationReportModel for a specified region
     * @param regionName the Region name
     * @return a HighLevelPopulationReportModel
     */
    public HighLevelPopulationReportModel getHighLevelPopulationDataForRegion(String regionName){

        var allCitiesInRegion = _cityService.getAllCitiesByRegionOrderedByPopulation(regionName);
        var allCountriesInRegion = _countryService.getAllCountriesInRegionOrderedByPopulation(regionName);

        if (allCountriesInRegion.size() == 0) return null;

        var model = new HighLevelPopulationReportModel();
        model.Name = regionName;
        model.Population = sumCountryPopulation(allCountriesInRegion);
        model.CityPopulation = sumCityPopulation(allCitiesInRegion);

        return model;
    }

    /**
     * Gets a HighLevelPopulationReportModel for a specified country
     * @param countryName the Country name
     * @return a HighLevelPopulationReportModel
     */
    public HighLevelPopulationReportModel getHighLevelPopulationDataForCountry(String countryName){

        var allCitiesInCountry = _cityService.getAllCitiesByCountryOrderedByPopulation(countryName);
        var country = _countryService.getCountryByName(countryName);

        if (country == null) return null;

        var model = new HighLevelPopulationReportModel();
        model.Name = countryName;
        model.Population = country.Population;
        model.CityPopulation = sumCityPopulation(allCitiesInCountry);

        return model;
    }

    /**
     * gets the total population of the world
     * @return the total population of the world as long
     */
    public long getPopulationOfWorld(){
        var allCountries = _countryService.getAllCountriesOrderByPopulation();

        return sumCountryPopulation(allCountries);
    }

    /**
     * gets the total population of a continent
     * @param continent the continent
     * @return the total population of the continent as long
     */
    public long getPopulationOfContinent(String continent){
        var allCountries = _countryService.getAllCountriesInContinentOrderedByPopulation(continent);

        return sumCountryPopulation(allCountries);
    }

    /**
     * gets the total population of a region
     * @param region the region
     * @return the total population of the region as long
     */
    public long getPopulationOfRegion(String region){
        var allCountries = _countryService.getAllCountriesInRegionOrderedByPopulation(region);

        return sumCountryPopulation(allCountries);
    }

    /**
     * gets the total population of a country
     * @param countryName the country name
     * @return the total population of the country as long
     */
    public long getPopulationOfCountry(String countryName){
        var country = _countryService.getCountryByName(countryName);

        if (country == null) return 0;

        return country.Population;
    }

    /**
     * gets the total population of a district
     * @param districtName the district name
     * @return the total population of the district as long
     */
    public long getPopulationOfDistrict(String districtName){
        var allCities = _cityService.getAllCitiesByDistrictOrderedByPopulation(districtName);

        return sumCityPopulation(allCities);
    }

    /**
     * gets the total population of a city
     * @param cityName the city name
     * @return the total population of the district as long
     */
    public long getPopulationOfCity(String cityName){
        City city = _cityService.getCityByName(cityName);

        if (city == null) return 0;

        return city.population;
    }
}
