package com.napier.sem.repositories;

import com.napier.sem.entities.City;
import com.napier.sem.entities.CityJoinCountry;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 19/02/2022 14:48
 * File Purpose: This class provides methods for accessing City data
 */
public class CityRepository {

    /**
     * The MySQL database connection
     */
    private final Connection con;

    /**
     * Creates a new instance of the CityRepository.
     * @param connection The database we will query
     */
    public CityRepository (Connection connection){
        con = connection;
    }

    /**
     * Gets all cities ordered by population ascending.
     * @return A list of all cities ordered by population ascending, the collection may be empty should no cities be
     * found.
     */
    public ArrayList<City> getAllCitiesOrderedByPopulation()
    {
        // Create string for SQL statement
        String strSelect =
                "SELECT ID, Name, CountryCode, District, Population "
                        + "FROM city ORDER BY Population DESC";

        return getCityCollection(strSelect);
    }

    /**
     * Gets all cities ordered by population ascending.
     * @return A list of all cities ordered by population ascending, the collection may be empty should no cities be
     * found.
     */
    public ArrayList<CityJoinCountry> getAllCitiesJoinCountryOrderedByPopulation()
    {
        // Create string for SQL statement
        String strSelect =
                "SELECT ci.Name, c.Name as Country, ci.Population, c.Continent, c.Region "
                        + "FROM city ci JOIN country c ON c.Code = ci.CountryCode " +
                        " ORDER BY Population DESC";

        return getCityJoinCountryCollection(strSelect);
    }

    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return A collection of Cities
     */
    private ArrayList<City> getCityCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            // create our collection
            ArrayList<City> cities = new ArrayList<>();

            // read the results and map to our entity
            while (resultSet.next())
            {
                City city = new City();

                city.id = resultSet.getInt("ID");
                city.name = resultSet.getString("Name");
                city.countryCode = resultSet.getString("CountryCode");
                city.district = resultSet.getString("district");
                city.population = resultSet.getInt("population");

                cities.add(city);
            }

            // return our collection
            return cities;
        }
        catch (Exception e)
        {
            // log exceptions to the screen
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return A collection of Cities
     */
    private ArrayList<CityJoinCountry> getCityJoinCountryCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            // create our collection
            ArrayList<CityJoinCountry> cities = new ArrayList<>();

            // read the results and map to our entity
            while (resultSet.next())
            {
                CityJoinCountry city = new CityJoinCountry();

                city.id = resultSet.getInt("ID");
                city.name = resultSet.getString("Name");
                city.countryCode = resultSet.getString("CountryCode");
                city.district = resultSet.getString("district");
                city.population = resultSet.getInt("population");
                city.Continent = resultSet.getString("continent");
                city.Region = resultSet.getString("region");

                cities.add(city);
            }

            // return our collection
            return cities;
        }
        catch (Exception e)
        {
            // log exceptions to the screen
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return An instance of City or null
     */
    private City getCity(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(SQLStatement);
            // Return new city if valid.

            // Check one is returned
            if (rset.next())
            {
                City cty = new City();
                cty.id = rset.getInt("ID");
                cty.name = rset.getString("Name");
                cty.countryCode = rset.getString("CountryCode");
                cty.district = rset.getString("district");
                cty.population = rset.getInt("population");
                return cty;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }

    }
}
