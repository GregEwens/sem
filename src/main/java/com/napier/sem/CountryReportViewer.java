package com.napier.sem;

import java.util.ArrayList;

public class CountryReportViewer {

    /**
     * An instance of the Country repository class
     */
    private final CountryRepository countryRepository;

    /**
     * The public constructor
     * @param countryRepo Pass an instance of the Country repository class
     */
    public CountryReportViewer(CountryRepository countryRepo){

        this.countryRepository = countryRepo;
    }


    /**
     * Displays all country ordered by population
     */
    public void ShowCountriesByPopulation(){
        var countries = countryRepository.getAllCountries();

        System.out.println("Report showing all countries ordered by population ascending");

        displayCountries(countries);
    }

    /**
     * Prints the details of a collection of countries
     * @param countries The collection of countries to display
     */
    private void displayCountries(ArrayList<Country> countries){
        for (var country: countries) {
            displayCountry(country);
        }
    }

    /**
     * Prints the details of a single country
     * @param ctry The country to display
     */
    private void displayCountry(Country ctry)
    {
        if (ctry != null)
        {
            System.out.println(
                    ctry.Code + " "
                            + ctry.Name + " "
                            + ctry.Continent + "\n"
                            + ctry.Region + "\n"
                            + "Population:" + ctry.Population + "\n" +
                            ctry.Capital + "\n");
        }
    }

}
