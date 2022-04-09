package com.napier.sem.models;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.models
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:13
 * File Purpose: Model for high level population reports.
 */
public class HighLevelPopulationReportModel {

    public String Name;

    public int Population;

    public int CityPopulation;

    private double GetPercentCityPopulation(){
        return ((double) CityPopulation / (double) Population) * 100;
    }

    private double PercentNotCityPopulation(){
        return (100.00 - GetPercentCityPopulation());
    }
}
