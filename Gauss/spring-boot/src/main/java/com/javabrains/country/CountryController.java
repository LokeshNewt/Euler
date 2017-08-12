package com.javabrains.country;

import entity.Country;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by neerbans on 8/2/2017.
 */

@RestController
public class CountryController {

    @RequestMapping("/countries")
    public List<Country> getAllCountries() {
        return Arrays.asList(
                new Country("Australia", "Canberra", "66,545,000"),
                new Country("Pakistan", "Islamabad", "540,545,000"),
                new Country("France", "Paris", "540,545,000")
        );
    }

}
