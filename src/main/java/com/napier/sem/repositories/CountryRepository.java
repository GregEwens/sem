package com.napier.sem.repositories;

import com.napier.sem.entities.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: Laura Main
 * Date Created: 19/02/2022
 * File Purpose: This class provides methods for accessing Country data
 */
@SuppressWarnings("PMD.SystemPrintln") // Prototype app using console for logging
public class CountryRepository implements ICountryRepository {

    /**
     * The MySQL database connection
     */
    private final Connection _con;

    /**
     * Creates a new instance of the CountryRepository.
     * @param connection The database we will query
     */
    public CountryRepository (Connection connection){
        _con = connection;
    }

    /**
     * @inheritDoc
     */
    @Override
    public ArrayList<Country> getAllCountriesOrderByPopulation() {
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
            Statement statement = _con.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            // create our collection
            ArrayList<Country> countries = new ArrayList<>();

            // read the results and map to our entity
            while (resultSet.next())
            {
                Country country = new Country();

                country.code = resultSet.getString("Code");
                country.name = resultSet.getString("Name");
                country.continent = resultSet.getString("Continent");
                country.region = resultSet.getString("Region");
                country.surfaceArea = resultSet.getBigDecimal("SurfaceArea");
                country.indepYear = resultSet.getShort("IndepYear");
                country.population = resultSet.getInt("Population");
                country.lifeExpectancy = resultSet.getBigDecimal("LifeExpectancy");
                country.gnp = resultSet.getBigDecimal("GNP");
                country.gnpOld = resultSet.getBigDecimal("GNPOld");
                country.localName = resultSet.getString("LocalName");
                country.governmentForm = resultSet.getString("GovernmentForm");
                country.headOfState = resultSet.getString("HeadOfState");
                country.capital = resultSet.getString("Capital");
                country.code2 = resultSet.getString("Code2");

                countries.add(country);
            }

            statement.close();
            resultSet.close();

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
