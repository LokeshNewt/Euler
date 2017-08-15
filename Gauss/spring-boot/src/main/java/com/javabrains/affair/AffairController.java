package com.javabrains.affair;

import entity.Country;
import entity.CurrentAffair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by neerbans on 8/2/2017.
 */

@RestController
public class AffairController {

    @Autowired
    private AffairService affairService;

    @RequestMapping("/countries/{id}/affairs")
    public List<CurrentAffair> getCurrentAffairs(@PathVariable Long id) {
        return affairService.getCurrentAffairs(id);
    }

    @RequestMapping("/countries/{countryId}/affaris/{id}")
    public CurrentAffair getCurrentAffair(@PathVariable Long id) {
        return affairService.getCurrentAffair(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/countries/{countryId}/affairs/")
    public void addCountry(@RequestBody CurrentAffair affair, @PathVariable Long countryId) {
        Country country = new Country(countryId);
        affair.setCountry(country);
        affairService.addAfair(affair);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/countries/{countryId}/affairs/")
    public void updateCountry(@RequestBody CurrentAffair affair, @PathVariable Long countryId) {
        Country country = new Country(countryId);
        affair.setCountry(country);
        affairService.updateCurrentAffair(affair);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/countries/{countryId}/affairs/{id}")
    public void deleteCurrentAffair(@PathVariable Long id) {
        affairService.deleteCurrentAffair(id);
    }

}
