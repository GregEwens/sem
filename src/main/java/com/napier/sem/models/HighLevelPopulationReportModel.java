package com.napier.sem.models;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.models
 * User: Greg Ewens
 * Date Created: 09/04/2022 14:13
 * File Purpose: Model for high level population reports.
 */
public class HighLevelPopulationReportModel {

    /**
     * The name of the geographic area
     */
    public String name;

    /**
     * The total population in the geographic area
     */
    public long population;

    /**
     * The population of the cities in the geographic area
     */
    public long cityPopulation;

    /**
     * Calculates the percentage of the geographic area who reside in cities
     * @return the percentage value as double
     */
    public double getPercentCityPopulation(){
        // return a zero to handle 0 population countries such as Antarctica
        if (population == 0 ) return 0;

        return ((double) cityPopulation / (double) population) * 100;
    }

    /**
     * Calculates the percentage of the geographic area who do not reside in cities
     * @return the percentage value as double
     */
    public double getPercentNotCityPopulation(){
        // return a zero to handle 0 population countries such as Antarctica
        if (population == 0 ) return 0;

        return (100.00 - getPercentCityPopulation());
    }
}
