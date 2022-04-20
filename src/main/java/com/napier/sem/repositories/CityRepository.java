package com.napier.sem.repositories;

import com.napier.sem.entities.City;
import com.napier.sem.entities.CityJoinCountry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.repositories
 * User: Greg Ewens
 * Date Created: 19/02/2022 14:48
 * File Purpose: This class provides methods for accessing City data
 */
@SuppressWarnings("PMD.SystemPrintln") // Prototype app using console for logging
public class CityRepository implements ICityRepository {

    /**
     * The MySQL database connection
     */
    private final Connection _con;

    /**
     * Creates a new instance of the CityRepository.
     * @param connection The database we will query
     */
    public CityRepository (Connection connection){
        _con = connection;
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<City> getAllCitiesOrderedByPopulation() {
        // Create string for SQL statement
        String strSelect =
                "SELECT ID, Name, CountryCode, District, Population "
                        + "FROM city ORDER BY Population DESC";

        return getCityCollection(strSelect);
    }

    /**
     * @inheritDoc
     */
    @Override
    public List<CityJoinCountry> getAllCitiesJoinCountryOrderedByPopulation() {
        // Create string for SQL statement
        String strSelect =
                "SELECT ci.Id, ci.Name, c.Name as Country, ci.CountryCode, ci.District, ci.Population," +
                        " ci.Population, c" +
                        ".Continent, c.Region "
                        + "FROM city ci JOIN country c ON c.Code = ci.CountryCode "
                        + "ORDER BY Population DESC";

        return getCityJoinCountryCollection(strSelect);
    }

    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return A collection of Cities
     */
    private List<City> getCityCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = _con.createStatement();

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

    /**
     * Queries the city table using the supplied SQL statement. This input is not validated and must be sanitised
     * before calling this method.
     * @param SQLStatement An SQL statement which must return one or more complete City entities
     * @return A collection of Cities
     */
    private List<CityJoinCountry> getCityJoinCountryCollection(String SQLStatement){
        try
        {
            // Create an SQL statement
            Statement statement = _con.createStatement();

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
                city.continent = resultSet.getString("continent");
                city.region = resultSet.getString("region");
                city.countryName = resultSet.getString("Country");

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
