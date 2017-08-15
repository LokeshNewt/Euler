package com.javabrains.affair;

import entity.Country;
import entity.CurrentAffair;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by neerbans on 15/8/17.
 */
public interface AffairRepository extends CrudRepository<CurrentAffair, Long> {

    List<CurrentAffair> findByCountryCountryId(Long countryId);
}
