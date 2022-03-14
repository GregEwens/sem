package com.napier.sem.entities;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.entities
 * User: Greg Ewens
 * Date Created: 19/02/2022 13:20
 * File Purpose: This class maps to the City database entity.
 */

/**
 * This class maps to the City database entity.
 */
public class City {
    /**
     * The City ID
     */
    public int id;

    /**
     * The City Name
     */
    public String name;

    /**
     * The three-letter country code
     */
    public String countryCode;

    /**
     * The district in which the city is located
     */
    public String district;

    /**
     * The population of the city
     */
    public int population;
}
