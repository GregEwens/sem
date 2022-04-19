package com.napier.sem.repositories;

import com.napier.sem.entities.CapitalCity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Project Name: seMethods.repositories
 * Package: com.napier.sem
 * User: Laura Main
 * Date Created: 12/03/2022 13:37
 * File Purpose:This class provides methods for accessing Capital City data
 */
@SuppressWarnings("PMD.SystemPrintln") // Prototype app using console for logging
public class CapitalCityRepository implements ICapitalCityRepository {

    /**
     * The MySQL database connection
     */
    private final Connection con;

    /**
     * Creates a new instance of the CityRepository.
     * @param connection The database we will query
     */
    public CapitalCityRepository (Connection connection){
        con = connection;
    }


    /**
     * Gets a collection of capital cities found in the world
     * @return Returns a sorted collection of Capital Cities
     */
    @Override
    public ArrayList<CapitalCity> getAllCapitalCitiesOrderedByPopulation()
    {
        // Create string for SQL statement
        String strSelect =
                "SELECT ci.Name, c.Name as Country, ci.Population, c.Continent, c.region "
                        + "FROM city ci JOIN country c ON c.Capital = ci.id "
                        + "ORDER BY Population DESC";

        return getCapitalCityCollection(strSelect);
    }


    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return A collection of Capital Cities
     */
    private ArrayList<CapitalCity> getCapitalCityCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();

            // Execute SQL statement
            ResultSet resultSet = statement.executeQuery(SQLStatement);

            // create our collection
            ArrayList<CapitalCity> cities = new ArrayList<>();

            // read the results and map to our entity
            while (resultSet.next())
            {
                CapitalCity city = new CapitalCity();

                city.name = resultSet.getString("Name");
                city.country = resultSet.getString("Country");
                city.population = resultSet.getInt("Population");
                city.Continent = resultSet.getString("Continent");
                city.region = resultSet.getString("region");

                cities.add(city);
            }

            statement.close();
            resultSet.close();

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
