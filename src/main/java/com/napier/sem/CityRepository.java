/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 19/02/2022 14:48
 * File Purpose: This class provides methods for accessing City data
 */

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
                        + "FROM city ORDER BY Population DESC";

        return getCityCollection(strSelect);
    }

    /**
     * Returns a single instance of City from the city ID
     * @param ID The city ID
     * @return The instance of city found or null
     */
    public City getCityById(int ID)
    {
        // Create string for SQL statement
        String strSelect =
                "SELECT ID, Name, CountryCode, District, Population "
                        + "FROM city "
                        + "WHERE ID = " + ID;

        return getCity(strSelect);
    }

    /**
     * Gets a collection of capital cities found in the specified continent
     * @param continent The continent to search, casing is unimportant
     * @param sortOrder The sort order.
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<CapitalCity> getAllCapitalCitiesByContinentOrderedByPopulation(String continent, SortOrder sortOrder)
    {
        //TODO: the string parameter should be encapsulated to prevent SQL injection.

        // Create string for SQL statement
        String strSelect =
                "SELECT ci.Name, c.Name as Country, ci.Population "
                        + "FROM city ci JOIN country c ON c.Code = ci.CountryCode WHERE c.Continent = '"
                        + continent
                        + "' AND ci.ID = c.Capital ORDER BY Population "
                        + buildOrderByStatement(sortOrder);

        return getCapitalCityCollection(strSelect);
    }

    /**
     * Gets a collection of cities found in the specified continent
     * @param continent The continent to search, casing is unimportant
     * @param sortOrder The sort order.
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByContinentOrderedByPopulation(String continent, SortOrder sortOrder)
    {
        //TODO: the string parameter should be encapsulated to prevent SQL injection.

        // Create string for SQL statement
        String strSelect =
                "SELECT ID, ci.Name, CountryCode, District, ci.Population "
                        + "FROM city ci JOIN country c ON c.Code = ci.CountryCode WHERE c.Continent = '" + continent  + "' ORDER BY Population " + buildOrderByStatement(sortOrder);

        return getCityCollection(strSelect);
    }

    /**
     * Gets a collection of cities found in the specified region
     * @param region The region to search, casing is unimportant
     * @param sortOrder The sort order.
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByRegionOrderedByPopulation(String region, SortOrder sortOrder)
    {
        //TODO: the string parameter should be encapsulated to prevent SQL injection.

        // Create string for SQL statement
        String strSelect =
                "SELECT ID, ci.Name, CountryCode, District, ci.Population "
                        + "FROM city ci JOIN country c ON c.Code = ci.CountryCode WHERE c.Region = '" + region  + "' ORDER BY Population " + buildOrderByStatement(sortOrder);

        return getCityCollection(strSelect);
    }

    /**
     * Gets a collection of cities found in the specified country
     * @param countryCode The countryCode to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByCountryOrderedByPopulation(String countryCode){
        var cities = getAllCitiesOrderedByPopulation();

        var citiesInCountry = new ArrayList<City>();

        for (var city:cities) {
            if (city.countryCode.equalsIgnoreCase(countryCode)){
                citiesInCountry.add(city);
            }
        }

        return citiesInCountry;
    }

    /**
     * Gets a collection of cities found in a given region
     * @param districtName The region name to search, casing is unimportant
     * @return Returns a sorted collection of Cities
     */
    public ArrayList<City> getAllCitiesByDistrictOrderedByPopulation(String districtName){
        var cities = getAllCitiesOrderedByPopulation();

        var citiesInDistrict = new ArrayList<City>();

        for (var city:cities) {
            if (city.district.equalsIgnoreCase(districtName)){
                citiesInDistrict.add(city);
            }
        }

        return citiesInDistrict;
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

    /**
     * Returns the sort order statement based on provided sort order enum.
     * @param sortOrder The sort order enum.
     * @return the sort order as a string statement.
     */
    private String buildOrderByStatement(SortOrder sortOrder){
        if (sortOrder == SortOrder.Ascending){
            return "ASC";
        }

        return "DESC";
    }
}
