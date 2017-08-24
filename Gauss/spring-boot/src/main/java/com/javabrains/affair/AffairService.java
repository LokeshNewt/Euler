package com.javabrains.affair;

import entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neerbans on 13/8/17.
 */

@Service
public class AffairService {

    @Autowired
    private AffairRepository affairRepository;

    public List<Event> getCurrentAffairs (Long countryId) {
        List<Event> events = new ArrayList<>();
        affairRepository.findByCountryCountryId(countryId).forEach(events::add);
        return events;
    }

    public Event getCurrentAffair (Long id) {
        return affairRepository.findOne(id);
    }

    public void addAfair(Event event) {
        affairRepository.save(event);
    }

    public void deleteCurrentAffair(Long id) {
        affairRepository.delete(id);
    }

    public void updateCurrentAffair(Event event) {
        affairRepository.save(event);
    }
}
