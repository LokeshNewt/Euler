package com.javabrains.country;

import entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/countries/{id}")
    public Country getCountryByName(@PathVariable Long id) {
        return countryService.getCountry(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/countries")
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/countries/{name}")
    public void updateCountry(@RequestBody Country country, @PathVariable String name) {
        countryService.updateCountry(name, country);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/countries/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }

}
