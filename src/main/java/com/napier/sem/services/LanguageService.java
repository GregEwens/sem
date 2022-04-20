package com.napier.sem.services;

import com.napier.sem.models.LanguageModel;
import com.napier.sem.repositories.ILanguageRepository;
import java.util.List;

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
    public List<LanguageModel> getDemographicReportModel(){
        var worldPopulation = _populationService.getPopulationOfWorld();
        var allLanguages =  _languageRepository.getAllLanguages();

        return buildLanguageModels(allLanguages, worldPopulation, _languagesOfInterest);
    }
}
