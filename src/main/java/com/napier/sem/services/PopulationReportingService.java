package com.napier.sem.services;

import com.napier.sem.entities.City;
import com.napier.sem.entities.Country;
import com.napier.sem.models.HighLevelPopulationReportModel;
import com.napier.sem.repositories.ICityRepository;
import com.napier.sem.repositories.ICountryRepository;

import javax.lang.model.element.Name;
import java.util.ArrayList;

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

    public HighLevelPopulationReportModel getHighLevelPopulationDataForContinent(String continentName){

        var allCitiesInContinent = _cityService.getAllCitiesByContinentOrderedByPopulation(continentName);
        var allCountriesInContinent = _countryService.getAllCountriesInContinentOrderedByPopulation(continentName);

        var model = new HighLevelPopulationReportModel();
        model.Name = continentName;
        model.Population = sumCountryPopulation(allCountriesInContinent);
        model.CityPopulation = sumCityPopulation(allCitiesInContinent);

        return model;
    }



}
