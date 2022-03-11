/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Laura Main
 * Date Created: 19/02/2022
 * File Purpose: This class provides methods for accessing Country data
 */

package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CountryRepository implements ICountryRepository {

    /**
     * The MySQL database connection
     */
    private final Connection con;

    /**
     * Creates a new instance of the CountryRepository.
     * @param connection The database we will query
     */
    public CountryRepository (Connection connection){
        con = connection;
    }

    /**
     * @inheritDoc
     */
    public ArrayList<Country> getAllCountriesOrderByPopulation()
    {
        // Create string for SQL statement
        String strSelect =
                "SELECT Code, country.Name, Continent, Region, SurfaceArea, IndepYear, country.Population, LifeExpectancy, GNP, " +
                        " GNPOld, LocalName, GovernmentForm, HeadOfState, city.name as Capital, Code2 "
                        + "FROM country " +
                        "LEFT JOIN city ON country.capital = city.id " +
                        "ORDER BY country.population DESC";

        return getCountryCollection(strSelect);
    }


    /**
     * Queries the country table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete Countries entities
     * @return A collection of Countries
     */
    private ArrayList<Country> getCountryCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            // create our collection
            ArrayList<Country> countries = new ArrayList<>();

            // read the results and map to our entity
            while (resultSet.next())
            {
                Country country = new Country();

                country.Code = resultSet.getString("Code");
                country.Name = resultSet.getString("Name");
                country.Continent = resultSet.getString("Continent");
                country.Region = resultSet.getString("Region");
                country.SurfaceArea = resultSet.getBigDecimal("SurfaceArea");
                country.IndepYear = resultSet.getShort("IndepYear");
                country.Population = resultSet.getInt("Population");
                country.LifeExpectancy = resultSet.getBigDecimal("LifeExpectancy");
                country.GNP = resultSet.getBigDecimal("GNP");
                country.GNPOld = resultSet.getBigDecimal("GNPOld");
                country.LocalName = resultSet.getString("LocalName");
                country.GovernmentForm = resultSet.getString("GovernmentForm");
                country.HeadOfState = resultSet.getString("HeadOfState");
                country.Capital = resultSet.getString("Capital");
                country.Code2 = resultSet.getString("Code2");

                countries.add(country);
            }

            // return our collection
            return countries;
        }
        catch (Exception e)
        {
            // log exceptions to the screen
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

}
