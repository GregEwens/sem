package com.napier.sem;

import com.napier.sem.reports.*;
import com.napier.sem.repositories.CapitalCityRepository;
import com.napier.sem.repositories.CityRepository;
import com.napier.sem.repositories.CountryRepository;
import com.napier.sem.repositories.LanguageRepository;
import com.napier.sem.services.*;

import java.sql.*;


/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: Greg Ewens
 * Date Created: 09/02/2022 14:42
 * File Purpose: The entry point of the application
 */
@SuppressWarnings("PMD.SystemPrintln") // Prototype app using console for output
public class App
{
    /**
     * Connection to MySQL database.
     */
    private static Connection con;

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
     * The PopulationReportingService, must be instantiated before use
     */
    public static PopulationReportingService populationReportingService;

    /**
     * The PopulationReportingService, must be instantiated before use
     */
    public static PopulationReportViewer populationReports;

    /**
     * The LanguageRepository, must be instantiated before use
     */
    public static LanguageRepository languageRepo;

    /**
     * The LanguageService, must be instantiated before use
     */
    public static LanguageService languageService;

    /**
     * The demographic report viewer
     */
    public static DemographicReportViewer demographicReports;

    /**
     * The entry point for the app
     * @param args index0: database location, index1: connection retry delay
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

    /**
     * Initialise static dependencies including the database connection
     * Wouldn't some dependency injection be useful here!!!
     * @param a The static instance of this class
     * @param args index0: database location, index1: connection retry delay
     */
    public static void initialise(App a, String... args){

        // Connect to database
        if(args.length < 1){
            a.connect("localhost:33060", 3000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // construct the CityRepository
        cityRepo = new CityRepository(con);

        // construct city service
        cityService = new CityService(cityRepo);

        // construct the cityReports
        cityReports = new CityReportViewer(cityService);

        // construct the CityRepository
        capitalCityRepo = new CapitalCityRepository(con);

        // construct city service
        capitalCityService = new CapitalCityService(capitalCityRepo);

        // construct the cityReports
        capitalCityReports = new CapitalCityReportViewer(capitalCityService);

        // construct the CountryRepository
        countryRepo = new CountryRepository(con);

        // construct the country service
        countryService = new CountryService(countryRepo);

        //construct the country Reports
        countryReports = new CountryReportViewer(countryService);

        //construct the population service
        populationReportingService = new PopulationReportingService(countryService, cityService);

        // construct the population report viewer
        populationReports = new PopulationReportViewer(populationReportingService);

        // construct the LanguageRepository
        languageRepo = new LanguageRepository(con);

        // construct the language service
        languageService = new LanguageService(languageRepo, populationReportingService);

        // construct the demographic report viewer
        demographicReports = new DemographicReportViewer(languageService);
    }

    /**
     * Run the world reports
     */
    public static void runReports(){
/*
        // show an example city
        cityReports.showCityDetails(5);

        // show the cities by population report
        cityReports.showCitiesByPopulation();

        // show cities in country by population
        cityReports.showCitiesInCountryByPopulation("DEU");

        // show cities in district by population
        cityReports.showCitiesInDistrictByPopulation("California");

        //show cities in a continent organised by largest population to smallest.
        cityReports.showCitiesInContinentByPopulation("Asia");

        //show cities in a region organised by largest population to smallest.
        cityReports.showCitiesInRegionByPopulation("Southern Europe");

        //show countries by population high to low
        countryReports.showCountriesByPopulation();

        //show countries in region by population high to low
        countryReports.showCountriesInARegionByPopulation("Southern Europe");

        //show countries in continent by population high to low
        countryReports.showCountriesInAContinentByPopulation("Asia");

        //show capital cities in a continent organised by largest population to smallest.
        capitalCityReports.showCapitalCitiesInContinentByPopulation("Europe");

        //show capital cities in the world organised by largest population to smallest.
        capitalCityReports.showCapitalCitiesByPopulation();

        // show top N countries by population
        countryReports.showTopNCountriesByPopulation(25);

        // show top N countries in continent by population
        countryReports.showTopNCountriesInContinentByPopulation(12, "Africa");

        // show top N countries in continent by population
        countryReports.showTopNCountriesInRegionByPopulation(12, "Southern Europe");

        // show top N cities by population
        cityReports.showTopNCitiesByPopulation(5);

        // show top N cities in district
        cityReports.showTopNCitiesInDistrictByPopulation(14, "Bremen");

        // show top N cities in country
        cityReports.showTopNCitiesInCountryByPopulation(35, "France");

        // show top N cities in continent
        cityReports.showTopNCitiesInContinentByPopulation(16, "Europe");

        // show top N cities in continent
        cityReports.showTopNCitiesInRegionByPopulation(16, "Southern Europe");
*/
        // show population report for country
        populationReports.showPopulationReportForCountry("France");

        // show population report for continent
        populationReports.showPopulationReportForContinent("North America");

        // show population report for region
        populationReports.showPopulationReportForRegion("Southern Europe");

        // show basic population report for the world
        populationReports.showBasicPopulationReportForWorld();

        // show basic population report for the world
        populationReports.showBasicPopulationReportForContinent("Antarctica");

        // show basic population report for the world
        populationReports.showBasicPopulationReportForRegion("Southern and Central Asia");

        // show basic population report for the world
        populationReports.showBasicPopulationReportForCountry("Jamaica");

        // show basic population report for the world
        populationReports.showBasicPopulationReportForDistrict("Lombardia");

        // show basic population report for the world
        populationReports.showBasicPopulationReportForCity("Edinburgh");

        // show the demographics of the world
        demographicReports.showKeyDemographicReport();

        // show the capital cities in a region
        capitalCityReports.showCapitalCitiesInRegionByPopulation("Middle East");

        // Show the top N capital cities in the world
        capitalCityReports.showTopNCapitalCitiesByPopulation(12);

        // Show the top N capital cities in a region
        capitalCityReports.showTopNCapitalCitiesInRegionByPopulation(3, "Middle East");

        // Show the top N capital cities in a Continent
        capitalCityReports.showTopNCapitalCitiesInContinentByPopulation(4, "Oceania");
    }

    /**
     * Connect to the MySQL database.
     * @param location the database location
     * @param delay connection retry delay
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
            // print error
            System.out.println("Could not load SQL driver");
            // exit
            System.exit(-1);
        }

        // try to connect to the database up to 10 times
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
                // print error
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                // print error
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
                // print error
                System.out.println("Error closing connection to database");
            }
        }
    }
}
