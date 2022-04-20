package com.napier.sem.entities;

import java.math.BigDecimal;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.entities
 * User: Laura Main
 * Date Created: 19/02/2022 22:07
 * File Purpose: This class maps to the Country database entity.
 */
@SuppressWarnings("unused") // This entity maps to the database table. Properties not used should be reviewed
// periodically and once the app is feature complete
public class Country
{
    /**
     * The unique country code to be used as a link identifier.
     */
    public String code;

    /**
     * The name of the country.
     */
    public String name;

    /**
     * The continent the country is on.
     */
    public String continent;

    /**
     * The region the country is in.
     */
    public String region;

    /**
     * The surface area of the country.
     */
    public BigDecimal surfaceArea;

    /**
     * The Indep year of the country,
     */
    public int indepYear;

    /**
     * The population of the country.
     */
    public long population;

    /**
     * The average life expectancy of the country.
     */
    public BigDecimal lifeExpectancy;

    /**
     * The Gross national Product of the country.
     */
    public BigDecimal gnp;

    /**
     * The old Gross national Product of the country.
     */
    public BigDecimal gnpOld;

    /**
     * The name of the country in its native language.
     */
    public String localName;

    /**
     * The form of the countries' government.
     */
    public String governmentForm;

    /**
     * The name of the head of state for the country.
     */
    public String headOfState;

    /**
     * The name of the capital city of the country.
     */
    public String capital;

    /**
     * CountryCode variant using 2 characters
     */
    public String code2;
}
