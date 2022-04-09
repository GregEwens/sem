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

    public double GetPercentCityPopulation(){
        // return a zero to handle 0 population countries such as Antarctica
        if (Population == 0 ) return 0;

        return ((double) CityPopulation / (double) Population) * 100;
    }

    public double GetPercentNotCityPopulation(){
        // return a zero to handle 0 population countries such as Antarctica
        if (Population == 0 ) return 0;

        return (100.00 - GetPercentCityPopulation());
    }
}
