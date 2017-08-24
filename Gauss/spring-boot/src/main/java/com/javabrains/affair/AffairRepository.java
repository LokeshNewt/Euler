package com.javabrains.affair;

import entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by neerbans on 15/8/17.
 */
public interface AffairRepository extends CrudRepository<Event, Long> {

    List<Event> findByCountryCountryId(Long countryId);
}
