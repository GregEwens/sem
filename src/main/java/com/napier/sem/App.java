/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 09/02/2022 14:42
 * File Purpose: The entry point of the application
 */

package com.napier.sem;

import com.napier.sem.reports.CapitalCityReportViewer;
import com.napier.sem.reports.CityReportViewer;
import com.napier.sem.reports.CountryReportViewer;
import com.napier.sem.repositories.CapitalCityRepository;
import com.napier.sem.repositories.CityRepository;
import com.napier.sem.repositories.CountryRepository;
import com.napier.sem.services.CapitalCityService;
import com.napier.sem.services.CityService;
import com.napier.sem.services.CountryService;

import java.sql.*;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * The CityRepository, must be instantiated before use
     */
    public CityRepository cityRepo;

    /**
     * The CityService, must be instantiated before use
     */
    public CityService cityService;

    /**
     * The CityReportViewer, must be instantiated before use
     */
    public CityReportViewer cityReports;

    /**
     * The CapitalCityRepository, must be instantiated before use
     */
    public CapitalCityRepository capitalCityRepo;

    /**
     * The CapitalCityService, must be instantiated before use
     */
    public CapitalCityService capitalCityService;

    /**
     * The CapitalCityReportViewer, must be instantiated before use
     */
    public CapitalCityReportViewer capitalCityReports;

    /**
     * The CountryRepository, must be instantiated before use
     */
    public CountryRepository countryRepo;

    /**
     * The CountryService, must be instantiated before use
     */
    public CountryService countryService;

    /**
     * The CountryReportViewer, must be instantiated before use
     */
    public CountryReportViewer countryReports;

    /**
     * The entry point for the app
     * @param args No arguments accepted
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // construct the CityRepository
        a.cityRepo = new CityRepository(a.con);

        // construct city service
        a.cityService = new CityService(a.cityRepo);

        // construct the cityReports
        a.cityReports = new CityReportViewer(a.cityService);

        // construct the CityRepository
        a.capitalCityRepo = new CapitalCityRepository(a.con);

        // construct city service
        a.capitalCityService = new CapitalCityService(a.capitalCityRepo);

        // construct the cityReports
        a.capitalCityReports = new CapitalCityReportViewer(a.capitalCityService);

        // construct the CountryRepository
        a.countryRepo = new CountryRepository(a.con);

        // construct the country service
        a.countryService = new CountryService(a.countryRepo);

        //construct the country Reports
        a.countryReports = new CountryReportViewer(a.countryService);

        // show an example city
        a.cityReports.ShowCityDetails(5);

        // show the cities by population report
        a.cityReports.ShowCitiesByPopulation();

        // show cities in country by population
        a.cityReports.ShowCitiesInCountryByPopulation("DEU");

        // show cities in district by population
        a.cityReports.ShowCitiesInDistrictByPopulation("California");

        //show cities in a continent organised by largest population to smallest.
        a.cityReports.ShowCitiesInContinentByPopulation("Asia");

        //show cities in a region organised by largest population to smallest.
        a.cityReports.ShowCitiesInRegionByPopulation("Southern Europe");

        //show countries by population high to low
        a.countryReports.ShowCountriesByPopulation();

        //show countries in region by population high to low
        a.countryReports.ShowCountriesInARegionByPopulation("Southern Europe");

        //show countries in continent by population high to low
        a.countryReports.ShowCountriesInAContinentByPopulation("Asia");

        //show capital cities in a continent organised by largest population to smallest.
        a.capitalCityReports.ShowCapitalCitiesInContinentByPopulation("Europe");

        // show top N countries by population
        a.countryReports.ShowTopNCountriesByPopulation(25);

        // show top N countries in continent by population
        a.countryReports.ShowTopNCountriesInContinentByPopulation(12, "Africa");

        // show top N cities by population
        a.cityReports.ShowTopNCitiesByPopulation(5);

        // show top N cities in district
        a.cityReports.ShowTopNCitiesInDistrictByPopulation(14, "Bremen");

        // show top N cities in country
        a.cityReports.ShowTopNCitiesInCountryByPopulation(35, "France");

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
