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
     * Gets all the current employees and salaries.
     * @return A list of all employees and salaries, or null if there is an error.
     */
    public ArrayList<City> getAllCities()
    {
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city ";

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(strSelect);

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
