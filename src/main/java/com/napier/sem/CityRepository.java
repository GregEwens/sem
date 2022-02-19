package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * A repository class for working with City objects in a MySQL database
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
     * Gets all cities.
     * @return A list of all cities, the collection may be empty should no cities be found.
     */
    public ArrayList<City> getAllCities()
    {
        // Create string for SQL statement
        String strSelect =
                "SELECT ID, Name, CountryCode, District, Population "
                        + "FROM city ";

        return getCityCollection(strSelect);
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
                        + "FROM city ORDER BY Population ASC";

        return getCityCollection(strSelect);
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
}
