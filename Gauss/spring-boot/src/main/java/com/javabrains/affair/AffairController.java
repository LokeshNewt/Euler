package com.javabrains.affair;

import entity.Event;
import entity.Country;
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
    public List<Event> getCurrentAffairs(@PathVariable Long id) {
        return affairService.getCurrentAffairs(id);
    }

    @RequestMapping("/countries/{countryId}/affaris/{id}")
    public Event getCurrentAffair(@PathVariable Long id) {
        return affairService.getCurrentAffair(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/countries/{countryId}/affairs/")
    public void addCountry(@RequestBody Event event, @PathVariable Long countryId) {
        Country country = new Country(countryId);
        event.setCountry(country);
        affairService.addAfair(event);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/countries/{countryId}/affairs/")
    public void updateCountry(@RequestBody Event event, @PathVariable Long countryId) {
        Country country = new Country(countryId);
        event.setCountry(country);
        affairService.updateCurrentAffair(event);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/countries/{countryId}/affairs/{id}")
    public void deleteCurrentAffair(@PathVariable Long id) {
        affairService.deleteCurrentAffair(id);
    }

}
