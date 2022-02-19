package com.napier.sem;

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
     * The CityReportViewer, must be instantiated before use
     */
    public CityReportViewer cityReports;

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

        // contruct the cityReports
        a.cityReports = new CityReportViewer(a.cityRepo);

        // show an example city
        a.cityReports.ShowCityDetails(5);

        // show the cities by population report
        a.cityReports.ShowCitiesByPopulation();

        // show cities in country by population
        a.cityReports.ShowCitiesInCountryByPopulation("DEU");

        // show cities in district by population
        a.cityReports.ShowCitiesInDistrictByPopulation("California");

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
