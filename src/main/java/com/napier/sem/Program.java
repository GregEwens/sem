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

import java.sql.Connection;

/**
 * Project Name: seMethods
 * Package: com.napier.sem
 * User: <<Your name here>>
 * Date Created: 13/03/2022 14:00
 * File Purpose:
 */
public class Program {
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

    public Program(Connection connection){

        con = connection;

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
    }
}
