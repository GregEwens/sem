package com.napier.sem.entities;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.entities
 * User: Greg Ewens
 * Date Created: 12/03/2022 13:26
 * File Purpose: DTO entity extends City and used when mapping from City joined to Country
 */
public class CityJoinCountry extends City {

    /**
     * The continent the country is on.
     */
    public String continent;

    /**
     * The region the country is in.
     */
    public String region;

    /**
     * The country the city is in
     */
    public String countryName;
}
