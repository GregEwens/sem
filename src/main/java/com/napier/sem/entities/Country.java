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
// periodically
public class Country
{
    /**
     * The unique country code to be used as a link identifier.
     */
    public String Code;

    /**
     * The name of the country.
     */
    public String Name;

    /**
     * The continent the country is on.
     */
    public String Continent;

    /**
     * The region the country is in.
     */
    public String Region;

    /**
     * The surface area of the country.
     */
    public BigDecimal SurfaceArea;

    /**
     * The Indep year of the country,
     */
    public short IndepYear;

    /**
     * The population of the country.
     */
    public long Population;

    /**
     * The average life expectancy of the country.
     */
    public BigDecimal LifeExpectancy;

    /**
     * The Gross national Product of the country.
     */
    public BigDecimal GNP;

    /**
     * The old Gross national Product of the country.
     */
    public BigDecimal GNPOld;

    /**
     * The name of the country in its native language.
     */
    public String LocalName;

    /**
     * The form of the countries' government.
     */
    public String GovernmentForm;

    /**
     * The name of the head of state for the country.
     */
    public String HeadOfState;

    /**
     * The name of the capital city of the country.
     */
    public String Capital;

    /**
     * CountryCode variant using 2 characters
     */
    public String Code2;
}
