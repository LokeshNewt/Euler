package com.javabrains.country;

import entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by neerbans on 8/2/2017.
 */

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getCountries();
    }

    @RequestMapping("/countries/{name}")
    public Country getCountryByName(@PathVariable String name) {
        return countryService.getCountry(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/countries")
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/countries/{name}")
    public void updateCountry(@RequestBody Country country, @PathVariable String name) {
        countryService.updateCountry(name, country);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/countries/{name}")
    public boolean deleteCountry(@PathVariable String name) {
        return countryService.deleteCountry(name);
    }

}
