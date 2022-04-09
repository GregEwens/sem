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
                            + reportData.GetPercentCityPopulation() + "\n"
                            + reportData.GetPercentNotCityPopulation() + "\n"
                            );
        }
    }
}
