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

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 09/02/2022 14:42
 * File Purpose: The entry point of the application
 */
public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * The CityRepository, must be instantiated before use
     */
    public static CityRepository cityRepo;

    /**
     * The CityService, must be instantiated before use
     */
    public static CityService cityService;

    /**
     * The CityReportViewer, must be instantiated before use
     */
    public static CityReportViewer cityReports;

    /**
     * The CapitalCityRepository, must be instantiated before use
     */
    public static CapitalCityRepository capitalCityRepo;

    /**
     * The CapitalCityService, must be instantiated before use
     */
    public static CapitalCityService capitalCityService;

    /**
     * The CapitalCityReportViewer, must be instantiated before use
     */
    public static CapitalCityReportViewer capitalCityReports;

    /**
     * The CountryRepository, must be instantiated before use
     */
    public static CountryRepository countryRepo;

    /**
     * The CountryService, must be instantiated before use
     */
    public static CountryService countryService;

    /**
     * The CountryReportViewer, must be instantiated before use
     */
    public static CountryReportViewer countryReports;

    /**
     * The entry point for the app
     * @param args No arguments accepted
     */
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        initialise(a, args);

        runReports();

        // Disconnect from database
        a.disconnect();
    }

    public static void initialise(App a, String[] args){

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // construct the CityRepository
        cityRepo = new CityRepository(a.con);

        // construct city service
        cityService = new CityService(cityRepo);

        // construct the cityReports
        cityReports = new CityReportViewer(cityService);

        // construct the CityRepository
        capitalCityRepo = new CapitalCityRepository(a.con);

        // construct city service
        capitalCityService = new CapitalCityService(capitalCityRepo);

        // construct the cityReports
        capitalCityReports = new CapitalCityReportViewer(capitalCityService);

        // construct the CountryRepository
        countryRepo = new CountryRepository(a.con);

        // construct the country service
        countryService = new CountryService(countryRepo);

        //construct the country Reports
        countryReports = new CountryReportViewer(countryService);
    }

    public static void runReports(){
        // show an example city
        cityReports.ShowCityDetails(5);

        // show the cities by population report
        cityReports.ShowCitiesByPopulation();

        // show cities in country by population
        cityReports.ShowCitiesInCountryByPopulation("DEU");

        // show cities in district by population
        cityReports.ShowCitiesInDistrictByPopulation("California");

        //show cities in a continent organised by largest population to smallest.
        cityReports.ShowCitiesInContinentByPopulation("Asia");

        //show cities in a region organised by largest population to smallest.
        cityReports.ShowCitiesInRegionByPopulation("Southern Europe");

        //show countries by population high to low
        countryReports.ShowCountriesByPopulation();

        //show countries in region by population high to low
        countryReports.ShowCountriesInARegionByPopulation("Southern Europe");

        //show countries in continent by population high to low
        countryReports.ShowCountriesInAContinentByPopulation("Asia");

        //show capital cities in a continent organised by largest population to smallest.
        capitalCityReports.ShowCapitalCitiesInContinentByPopulation("Europe");

        // show top N countries by population
        countryReports.ShowTopNCountriesByPopulation(25);

        // show top N countries in continent by population
        countryReports.ShowTopNCountriesInContinentByPopulation(12, "Africa");

        // show top N cities by population
        cityReports.ShowTopNCitiesByPopulation(5);

        // show top N cities in district
        cityReports.ShowTopNCitiesInDistrictByPopulation(14, "Bremen");

        // show top N cities in country
        cityReports.ShowTopNCitiesInCountryByPopulation(35, "France");

        // show top N cities in continent
        cityReports.ShowTopNCitiesInContinentByPopulation(16, "Europe");
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay)
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
            System.out.println("Connecting to database at location " + location + "...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(delay);

                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
