package com.carl.friedrich.service;

import entity.Country;

import java.util.*;

/**
 * Created by neerbans on 10/9/2017.
 */
public class CountryService {

    private Map<Long, Country> countries = new HashMap<>();

    public CountryService() {
        countries.put(1L, new Country(1L, "France", "Paris", 100d));
        countries.put(2L, new Country(2L, "Spain", "Madrid", 231d));
    }

    public List<Country> getAllCountries() {
        return new ArrayList<>(countries.values());
    }

    public List<Country> getAllCountriesForYear(int year) {
        List<Country> countriesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Country country : countries.values()) {
            cal.setTime(country.getCreatedDate());
            if (cal.get(Calendar.YEAR) == year) {
                countriesForYear.add(country);
            }
        }
        return countriesForYear;
    }

    public List<Country> getAllCountriesPaginated(int start, int size) {
        ArrayList<Country> list = new ArrayList<>(countries.values());
        return list.subList(start, start + size);
    }

    public Country getCountry(long id) {
        return countries.get(id);
    }

    public Country addCountry(Country country) {
        country.setCountryId((long) countries.size() + 1);
        countries.put(country.getCountryId(), country);
        return country;
    }
}
