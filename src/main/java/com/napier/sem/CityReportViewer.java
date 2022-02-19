package com.napier.sem;

public class CityReportViewer {

    private final CityRepository cityRepository;

    public CityReportViewer(CityRepository cityRepo){
        this.cityRepository = cityRepo;
    }

    public void ShowCityDetails(int Id){
        var city = cityRepository.getCityById(Id);

        System.out.println("Data found for city with Id: " + Id);

        displayCity(city);
    }

    public void ShowCitiesByPopulation(){
        var cities = cityRepository.getAllCitiesOrderedByPopulation();

        System.out.println("Report showing all cities ordered by population ascending");

        for (var city: cities) {
            displayCity(city);
        }
    }

    private void displayCity(City cty)
    {
        if (cty != null)
        {
            System.out.println(
                    cty.id + " "
                            + cty.name + " "
                            + cty.countryCode + "\n"
                            + cty.district + "\n"
                            + "Population:" + cty.population + "\n");
        }
    }
}
