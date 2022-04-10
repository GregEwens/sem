package com.napier.sem.reports;

import com.napier.sem.models.LanguageModel;
import com.napier.sem.services.LanguageService;

import java.util.ArrayList;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.reports
 * User: Greg Ewens
 * Date Created: 10/04/2022 19:48
 * File Purpose: This class provides methods for viewing Demographic reports
 */
public class DemographicReportViewer {

    /**
     * An instance of the language repository class
     */
    private final LanguageService _languageService;

    /**
     * The public constructor
     * @param languageService Pass an instance of the language service class
     */
    public DemographicReportViewer(LanguageService languageService){

        _languageService = languageService;
    }

    /**
     * displays the key demographic report for 6 key languages
     */
    public void ShowKeyDemographicReport(){
        var model = _languageService.getDemographicReportModel();

        System.out.println("Key demographic report");

        displayDemographics(model);
    }

    /**
     * prints the details of a collection of languages
     * @param model the collection of languages
     */
    private void displayDemographics(ArrayList<LanguageModel> model) {

        for (var languageModel:model) {
            displayLanguageDemographic(languageModel);
        }
    }

    /**
     * prints the details of a single language
     * @param model the language
     */
    private void displayLanguageDemographic(LanguageModel model) {
        if (model != null)
        {
            System.out.println(
                    model.LanguageName + " "
                            + "Speakers: " + model.Speakers + " "
                            + "Percentage of World: " + model.GetSpeakersAsPercentageOfWorld());
        }
    }
}
