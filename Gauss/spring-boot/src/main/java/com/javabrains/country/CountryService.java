package com.javabrains.country;

import entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neerbans on 13/8/17.
 */

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

//    private List<Country> countries = new ArrayList<>(Arrays.asList(
//            new Country("Australia", "Canberra", 66.545),
//    new Country("Pakistan", "Islamabad", 540.545),
//    new Country("France", "Paris", 540.545)
//    ));

    public List<Country> getCountries () {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    public Country getCountry (Long id) {
        return countryRepository.findOne(id);
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.delete(id);
    }

    public void updateCountry(String name, Country country) {
        countryRepository.save(country);
    }
}
