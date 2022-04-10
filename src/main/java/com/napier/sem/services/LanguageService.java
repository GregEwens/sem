package com.napier.sem.services;

import com.napier.sem.entities.SpokenLanguageJoinCountry;
import com.napier.sem.models.DemographicReportModel;
import com.napier.sem.models.LanguageModel;
import com.napier.sem.repositories.ILanguageRepository;
import com.sun.source.tree.ArrayAccessTree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

import static com.napier.sem.helpers.PopulationHelpers.*;
import static com.napier.sem.helpers.LanguageHelpers.*;

/**
 * Project Name: seMethods
 * Package: com.napier.sem.services
 * User: Greg Ewens
 * Date Created: 09/04/2022 17:09
 * File Purpose: Processes business logic for demographic reports
 */
public class LanguageService {

    /**
     * The Language Repository
     */
    private final ILanguageRepository _languageRepository;

    /**
     * The Language Repository
     */
    private final PopulationReportingService _populationService;

    /**
     * The hard coded languages of interest
     */
    private final String[] _languagesOfInterest = {"Chinese", "English", "Hindi", "Spanish", "Arabic"};

    /**
     * The public constructor
     * @param languageRepository An instance of the ILanguageRepository
     */
    public LanguageService(ILanguageRepository languageRepository, PopulationReportingService populationService){

        _languageRepository = languageRepository;
        _populationService = populationService;
    }

    /**
     * Gets a collection of all capital cities
     * @return Returns a sorted DemographicReportModel
     */
    public DemographicReportModel getDemographicReportModel(){
        var worldPopulation = _populationService.getPopulationOfWorld();
        var allLanguages =  _languageRepository.getAllLanguages();

        var model = new DemographicReportModel();
        model.languageModels = getLanguageModels(allLanguages, worldPopulation);

        return model;
    }

    private ArrayList<LanguageModel> getLanguageModels(ArrayList<SpokenLanguageJoinCountry> allLanguages, long worldPopulation){
        var languageModels = new ArrayList<LanguageModel>();

        for (var language: _languagesOfInterest  ) {
            var spokenLanguage = getCountriesWithLanguage(allLanguages, language);

            languageModels.add(new LanguageModel(language, sumLanguageCount(spokenLanguage), worldPopulation));
        }

        Collections.sort(languageModels);

        return languageModels;
    }
}
