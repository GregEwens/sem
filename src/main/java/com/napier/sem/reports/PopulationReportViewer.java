package com.napier.sem.reports;

import com.napier.sem.models.HighLevelPopulationReportModel;
import com.napier.sem.services.PopulationReportingService;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.reports
 * User: Greg Ewens
 * Date Created: 09/04/2022 15:17
 * File Purpose: This class provides methods for viewing population reports
 */
public class PopulationReportViewer {

    /**
     * An instance of the Country repository class
     */
    private final PopulationReportingService _populationService;

    /**
     * The public constructor
     * @param populationService an instance of the PopulationReportingService service class
     */
    public PopulationReportViewer(PopulationReportingService populationService){
        _populationService = populationService;
    }

    /**
     * Displays a population report for a specified continent
     * @param continentName the name of the continent to display
     */
    public void ShowPopulationReportForContinent(String continentName){
        var reportData = _populationService.getHighLevelPopulationDataForContinent(continentName);

        System.out.println("Report showing the population details of " + continentName);

        displayPopulationReport(reportData);
    }

    /**
     * Displays a population report for a specified region
     * @param regionName the name of the region to display
     */
    public void ShowPopulationReportForRegion(String regionName){
        var reportData = _populationService.getHighLevelPopulationDataForRegion(regionName);

        System.out.println("Report showing the population details of " + regionName);

        displayPopulationReport(reportData);
    }

    /**
     * Displays a population report for a specified country
     * @param countryName the name of the country to display
     */
    public void ShowPopulationReportForCountry(String countryName){
        var reportData = _populationService.getHighLevelPopulationDataForCountry(countryName);

        System.out.println("Report showing the population details of " + countryName);

        displayPopulationReport(reportData);
    }

    /**
     * Displays the population of the world
     */
    public void ShowBasicPopulationReportForWorld(){
        var population = _populationService.getPopulationOfWorld();

        System.out.println("The population of the world is: " + population);
    }

    /**
     * Displays the population of a specified continent
     * @param continent the continent to show
     */
    public void ShowBasicPopulationReportForContinent(String continent){
        var population = _populationService.getPopulationOfContinent(continent);

        System.out.println("The population of " + continent +  " is: " + population);
    }

    /**
     * Displays the population of a specified region
     * @param region the region to show
     */
    public void ShowBasicPopulationReportForRegion(String region){
        var population = _populationService.getPopulationOfRegion(region);

        System.out.println("The population of " + region +  " is: " + population);
    }

    /**
     * Displays the population of a specified country
     * @param country the country to show
     */
    public void ShowBasicPopulationReportForCountry(String country){
        var population = _populationService.getPopulationOfCountry(country);

        System.out.println("The population of " + country +  " is: " + population);
    }

    /**
     * Displays the population of a specified district
     * @param district the district to show
     */
    public void ShowBasicPopulationReportForDistrict(String district){
        var population = _populationService.getPopulationOfDistrict(district);

        System.out.println("The population of " + district +  " is: " + population);
    }

    /**
     * Displays the population of a specified city
     * @param city the city to show
     */
    public void ShowBasicPopulationReportForCity(String city){
        var population = _populationService.getPopulationOfCity(city);

        System.out.println("The population of " + city +  " is: " + population);
    }

    /**
     * Prints a population report
     * @param reportData The data to display
     */
    private void displayPopulationReport(HighLevelPopulationReportModel reportData)
    {
        if (reportData != null)
        {
            System.out.println(
                    reportData.Name + "\n"
                            + reportData.Population + "\n"
                            + reportData.CityPopulation + "\n"
                            + (reportData.Population - reportData.CityPopulation) + "\n"
                            + reportData.GetPercentCityPopulation() + "\n"
                            + reportData.GetPercentNotCityPopulation() + "\n"
                            );
        }
    }
}
